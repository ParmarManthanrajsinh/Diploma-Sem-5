# to  calculate  mean  across  dimension,  in  a  2D 
# numpy array

import numpy as np

array_2d = np.array([[1, 2, 3], [4, 5, 6]])

mean_row = np.mean(array_2d, axis=1)
mean_col = np.mean(array_2d, axis=0)

print("Mean across rows:", mean_row)
print("Mean across columns:", mean_col)
