from flask import Flask, request, jsonify

app = Flask(__name__)

# Replace this with your actual API key
VALID_API_KEY = "your_api_key"

# Sample data from your screenshot
contact_data = [
    {
        "contact_name": "example",
        "email": "example@example.com"
    },
    {
        "contact_name": "Second",
        "email": "Secondexample@example.com"
    }
]

@app.route('/get-contacts', methods=['GET'])
def get_contacts():
    # Check for 'api_key' in the query parameters
    api_key = request.args.get('api_key')
    if api_key != VALID_API_KEY:
        return jsonify({"error": "Unauthorized"}), 401

    # Return the questions in JSON format
    return jsonify(contact_data), 200

if __name__ == '__main__':
    # Run in debug mode for easier development
    app.run(debug=True)
