# Write a Python program using Scikit-learn to print the 
# keys,  number  of  rows-columns,  feature  names  and 
# the description of the given data.

import pandas as pd

data = pd.read_csv("data.csv")

print("Keys: ", data.keys())
print("Number of rows and columns: ", data.shape)
print("Feature names: ", data.columns)
print("Description: ", data.describe())
print("Data: ", data)