# Sort a given Series

import pandas as pd

s = pd.Series([30, 10, 50, 20, 40])

sorted_series = s.sort_values()

print(sorted_series)