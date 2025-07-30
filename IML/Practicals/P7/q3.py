# to delete the one specific column from the DataFrame 

import pandas as pd

dist = {
    'name': ['A', 'B', 'C', 'D'],
    'age': [25, 30, 22, 28],
}

df = pd.DataFrame(dist)
df.drop(columns='name', inplace=True)
print(df)