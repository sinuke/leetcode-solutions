import pandas as pd

def modifySalaryColumn(employees: pd.DataFrame) -> pd.DataFrame:
    salary = employees['salary'].apply(lambda x: x * 2)
    employees['salary'] = salary

    return employees