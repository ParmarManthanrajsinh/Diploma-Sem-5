import numpy as np

arr = np.arange(14)
print("Original array:", arr)

a, b, c = np.split(arr, [2, 6])
print("Split arrays:")
print("First array (2 elements):", a)
print("Second array (4 elements):", b)
print("Third array (8 elements):", c)