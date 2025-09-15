# Write  a  Pandas  program  to  implement  following 
# operation 
# • to remove the duplicates from the given 
# dataset

import pandas as pd

df = pd.read_csv("data.csv")
print(df.duplicated())
print(df.drop_duplicates())