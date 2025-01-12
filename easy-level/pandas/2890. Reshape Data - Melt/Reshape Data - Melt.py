import pandas as pd

def meltTable(report: pd.DataFrame) -> pd.DataFrame:
    return pd.melt(report, id_vars=['product']).rename(columns={'variable':'quarter', 'value':'sales'})