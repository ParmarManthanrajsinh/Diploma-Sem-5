# Write a Python program to implement K-Nearest Neighbour supervised
# machine learning algorithm for given dataset.

from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score, classification_report

iris = load_iris()
x, y = iris.data, iris.target

# Split dataset into training and testing sets
x_train, x_test, y_train, y_test = train_test_split(
    x, y, test_size=0.2, random_state=42
)

k = 5
knn = KNeighborsClassifier(n_neighbors=k)

knn.fit(x_train, y_train)

y_pred = knn.predict(x_test)

accuracy = accuracy_score(y_test, y_pred)
report = classification_report(y_test, y_pred, target_names=iris.target_names)

print(f"Accuracy: {accuracy:.2f}")
print("\nClassification Report:\n", report)

sample = [[5.1, 3.5, 1.4, 0.2]]
predicted_class = knn.predict(sample)[0]
print(f"\nPredicted class for sample {sample}: {iris.target_names[predicted_class]}")
