# Convert the first column of a DataFrame to a Series

import pandas as pd

df = pd.DataFrame({
    'A': [1, 2, 3],
    'B': [4, 5, 6]
})
first_col_series = df.iloc[:, 0]
print(first_col_series)