import numpy as np

x = np.array([[1, 2, 3], [4, 5, 6]])
y = np.array([[7, 8, 9], [10, 11, 12]])
print("Array x:\n", x)
print("Array y:\n", y)

stacked = np.hstack((x, y))
print("Horizontally stacked array:\n", stacked)