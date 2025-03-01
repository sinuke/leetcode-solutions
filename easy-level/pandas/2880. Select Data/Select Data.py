import pandas as pd

def selectData(students: pd.DataFrame) -> pd.DataFrame:
    filtered = students.loc[students['student_id'] == 101]
    return filtered[['name', 'age']]