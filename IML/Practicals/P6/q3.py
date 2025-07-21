# Create the mean and standard deviation of the data of a given Series

import pandas as pd

s = pd.Series([10, 20, 30, 40, 50])

mean = s.mean()
std_dev = s.std()

print("Mean:", mean)
print("Standard Deviation:", std_dev)