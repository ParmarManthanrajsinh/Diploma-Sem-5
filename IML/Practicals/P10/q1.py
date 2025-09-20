# Write  a  Pandas  program  to  implement  following 
# operation 
# • to  find  and  drop  the  missing  values  from  the 
# given dataset

import pandas as pd

data = pd.read_csv('data.csv')
data.dropna(inplace=True)
print(data)