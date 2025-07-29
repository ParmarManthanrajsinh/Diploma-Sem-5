# to write a DataFrame to CSV file using tab separator 

import pandas as pd

dist = {
    'name': ['A', 'B', 'C', 'D'],
    'age': [25, 30, 22, 28],
}
df = pd.DataFrame(dist)
df.to_csv('output.csv', sep='\t', index=False)