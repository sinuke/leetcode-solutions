import pandas as pd

def getDataframeSize(players: pd.DataFrame) -> List[int]:
    return [len(players.index), len(players.columns)]