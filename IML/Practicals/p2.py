# Write  a  NumPy  program  to  implement  following 
# operation 
# •  to  convert  a  list  of  numeric  values  into  a one-
# dimensional NumPy array 
# •  to create a 3x3 matrix with values ranging from 
# 2 to 10 
# •  to append values at the end of an array 
# •  to create another shape from an array without 
# changing its data (3*2 to 2*3)

import numpy as np

numbers = [1, 2, 3, 4, 5]

np_array = np.array(numbers)
print("One-dimensional NumPy array:" + str(np_array))

matrix = np.arange(2, 11).reshape(3, 3)
print("3x3 matrix with values from 2 to 10:\n" + str(matrix))

np_array = np.append(np_array, [6, 7, 8])
print("Array after appending values at the end: " + str(np_array))

array_3x2 = np.arange(1,7).reshape(3, 2)
array_2x3 = array_3x2.reshape(2, 3)

print("3x2 array:\n" + str(array_3x2))
print("2x3 array:\n" + str(array_2x3))