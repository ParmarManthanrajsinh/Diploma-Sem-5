# to  round elements of  the array  to  the  nearest 
# integer

import numpy as np

a = np.array([10, 20, 30])
b = np.array([1, 2, 3])

add_result = np.add(a, b)
sub_result = np.subtract(a, b)
mul_result = np.multiply(a, b)
div_result = np.divide(a, b)

print("Add:", add_result)
print("Subtract:", sub_result)
print("Multiply:", mul_result)
print("Divide:", div_result)