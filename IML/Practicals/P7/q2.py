# to sort the DataFrame first by 'name' in ascending order 

import pandas as pd

dist = {
    'name': ['D', 'A', 'C', 'B'],
}

df = pd.DataFrame(dist)
df_sorted = df.sort_values(by='name')
print(df_sorted)