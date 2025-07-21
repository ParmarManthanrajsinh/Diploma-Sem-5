# Compute the mean, standard deviation, and variance of a given array along the second axis

import numpy as np

arr = np.array([[1, 2, 3], [4, 5, 6]])

mean_values = np.mean(arr, axis=1)
std_values = np.std(arr, axis=1)
var_values = np.var(arr, axis=1)

print("Mean:", mean_values)
print("Standard Deviation:", std_values)
print("Variance:", var_values)
