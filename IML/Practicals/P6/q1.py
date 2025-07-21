# Convert a NumPy array to a Pandas Series

import numpy as np
import pandas as pd

arr = np.array([10, 20, 30, 40, 50])
series = pd.Series(arr)
print(series)
