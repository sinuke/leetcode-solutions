#!/usr/bin/env python3
import json
import os
import sys
import importlib.util
import typing

import numpy as np
import pandas as pd


def load_input(spec, base_dir):
    file_path = os.path.join(base_dir, spec["file"])
    with open(file_path, encoding="utf-8") as f:
        raw = json.load(f)
    input_type = spec.get("type", "dataframe")
    if input_type == "dataframe":
        return pd.DataFrame(raw)
    else:
        return raw


def to_python_value(val):
    if val is None:
        return None
    try:
        if pd.isna(val):
            return None
    except (TypeError, ValueError):
        pass
    if isinstance(val, (bool, np.bool_)):
        return bool(val)
    if isinstance(val, (int, np.integer)):
        return int(val)
    if isinstance(val, (float, np.floating)):
        f = float(val)
        if f == int(f):
            return int(f)
        return f
    return val


def serialize_result(result):
    if isinstance(result, pd.DataFrame):
        if result.index.name is not None:
            result = result.reset_index()
        else:
            result = result.reset_index(drop=True)
        records = [
            {col: to_python_value(row[col]) for col in result.columns}
            for _, row in result.iterrows()
        ]
        return json.dumps(records)
    elif hasattr(result, "__iter__") and not isinstance(result, str):
        return json.dumps([to_python_value(v) for v in result])
    else:
        return json.dumps(to_python_value(result))


def main():
    meta_path = sys.argv[1]
    solution_path = sys.argv[2]

    with open(meta_path, encoding="utf-8") as f:
        meta = json.load(f)

    base_dir = os.path.dirname(os.path.abspath(meta_path))

    spec = importlib.util.spec_from_file_location("solution", solution_path)
    module = importlib.util.module_from_spec(spec)
    module.__dict__.update({k: v for k, v in vars(typing).items() if not k.startswith("_")})
    spec.loader.exec_module(module)

    fn = getattr(module, meta["function"])
    args = [load_input(inp, base_dir) for inp in meta.get("inputs", [])]
    result = fn(*args)

    print(serialize_result(result))


if __name__ == "__main__":
    main()
