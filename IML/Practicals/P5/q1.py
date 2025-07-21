# Find the maximum and minimum value of a given flattened array

import numpy as np

arr = np.array([[1, 3, 5], [2, 4, 6]])
flat_arr = arr.flatten()

max_val = np.amax(flat_arr)
min_val = np.amin(flat_arr)

print("Maximum value:", max_val)
print("Minimum value:", min_val)
