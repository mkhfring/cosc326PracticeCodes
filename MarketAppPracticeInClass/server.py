from flask import Flask, jsonify

app = Flask(__name__)

# Directly define the list of items as dictionaries
items = [
    {"image": "fruit", "title": "ApiFruits", "description": "Fresh Fruits from the Garden"},
    {"image": "vegitables", "title": "ApiVegetables", "description": "Delicious Vegetables"},
    {"image": "bread", "title": "ApiBakery", "description": "Bread, Wheat and Beans"},
    {"image": "beverage", "title": "Beverage", "description": "Juice, Tea, Coffee and Soda"},
    {"image": "milk", "title": "Milk", "description": "Milk, Shakes and Yogurt"},
    {"image": "popcorn", "title": "Snacks", "description": "Pop Corn, Donut and Drinks"}
]

@app.route('/items', methods=['GET'])
def get_items():
    return jsonify(items)

if __name__ == '__main__':
    app.run(debug=True)

