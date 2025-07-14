# Write  a  NumPy  program  to  implement  following 
# operation 
# • to  split  an  array  of  14  elements  into  3  arrays, 
# each  with  2,  4,  and  8  elements  in  the  original 
# order 
# • to stack arrays horizontally (column wise)

import numpy as np

elements = np.arange(1, 15)

arrays = np.split(elements, [2,6])

print(arrays[0])
print(arrays[1])
print(arrays[2])