import numpy as np
import pandas as pd
from matplotlib import pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
import xgboost as xgb

data_set = pd.read_csv("kc_house_data.csv")
data_set.dropna(inplace=True)

features1 = ['bedrooms', 'bathrooms', 'sqft_living', 'sqft_lot', 'floors', 'zipcode']
target = 'price' 

x1 = data_set[features1]
y1 = data_set[target]

# plt.scatter(x1['sqft_living'], y1)
# plt.xlabel('sqft_living')
# plt.ylabel('price')
# plt.title('Price vs Sqft Living')
# plt.show()

x_train ,x_test ,y_train ,y_test = train_test_split(x1,y1,test_size=0.2,random_state=42)

# plt.figure(figsize=(12, 5))

# plt.subplot(1, 2, 1)
# plt.scatter(x_train['sqft_living'], y_train, alpha=0.5, color='blue')
# plt.xlabel('sqft_living')
# plt.ylabel('price')
# plt.title('Train Data')

# plt.subplot(1, 2, 2)
# plt.scatter(x_test['sqft_living'], y_test, alpha=0.5, color='green')
# plt.xlabel('sqft_living')
# plt.ylabel('price')
# plt.title('Test Data')

# plt.tight_layout()
# plt.show()

model = xgb.XGBRegressor(random_state=42)
model.fit(x_train, y_train)

y_pred = model.predict(x_test)

score = model.score(x_test, y_test)
print("Model Score:", score)


new_house = pd.DataFrame({'bedrooms': [3], 'bathrooms': [1], 'sqft_living': [1180], 'sqft_lot': [5000], 'floors': [1], 'zipcode': [98178]})
predicted_price = model.predict(new_house)
print("Predicted Price:", predicted_price[0])
