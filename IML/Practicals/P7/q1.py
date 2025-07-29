# to create a dataframe from a dictionary and display it 

import pandas as pd

dist = {
    'name' : ['A', 'B', 'C', 'D'],
}

df = pd.DataFrame(dist)
print(df)