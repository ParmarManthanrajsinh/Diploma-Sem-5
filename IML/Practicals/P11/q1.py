# Write a Pandas program to filter all columns where all
# entries present, check which rows and columns has a
# NaN  and  finally  drop  rows  with  any  NaNs  from  the
# given dataset.

import pandas as pd
import numpy as np

df = pd.DataFrame([[1, 2, 3], [4, 5, 6], [7, 8, 9], [np.nan, np.nan, np.nan]])

print("Original DataFrame:")
print(df)
print("\nAll columns where all entries present:")
print(df.dropna(how="all"))
print("\nRows and columns has a NaN:")
print(df.dropna(axis=1, how="any"))
print("\nDrop rows with any NaNs:")
print(df.dropna(axis=0, how="any"))
