import pandas as pd

def findHeavyAnimals(animals: pd.DataFrame) -> pd.DataFrame:
    filtered = animals.loc[animals['weight'] > 100]
    sorted = filtered.sort_values(by='weight', ascending=False)
    return pd.DataFrame(sorted['name'])