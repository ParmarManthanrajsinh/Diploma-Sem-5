# Write  a  Pandas  program  to  create  a  line  plot  of  the 
# opening, closing stock prices of given company 
# between two specific dates.

import pandas as pd
import matplotlib.pyplot as plt

stock_data = {
    'Date': ['2023-01-01', '2023-01-02', '2023-01-03', '2023-01-04', '2023-01-05'],
    'Open': [150, 152, 153, 155, 154],
    'Close': [151, 153, 154, 156, 155]
}

df = pd.DataFrame(stock_data)

df.plot(x='Date', y=['Open', 'Close'], kind='line', marker='o')

plt.show()
