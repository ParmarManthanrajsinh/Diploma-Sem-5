# to calculate the difference between 
# neighboring elements, element-wise of a given 
# array 

import numpy as np

array = np.array([5, 10, 15, 20])

difference = np.diff(array)

print("Differences:", difference)
