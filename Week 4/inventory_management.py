# inventory_management.py

# Lists
product_names = ["Product1", "Product2", "Product3"]

def add_product(name):
    product_names.append(name)

def remove_product(name):
    if name in product_names:
        product_names.remove(name)

def update_product(old_name, new_name):
    if old_name in product_names:
        index = product_names.index(old_name)
        product_names[index] = new_name

# Dictionaries
product_details = {
    "Product1": {"quantity": 10, "price": 100},
    "Product2": {"quantity": 5, "price": 150},
    "Product3": {"quantity": 7, "price": 200},
}

def add_product_detail(name, quantity, price):
    product_details[name] = {"quantity": quantity, "price": price}

def update_product_detail(name, quantity=None, price=None):
    if name in product_details:
        if quantity is not None:
            product_details[name]["quantity"] = quantity
        if price is not None:
            product_details[name]["price"] = price

def delete_product_detail(name):
    if name in product_details:
        del product_details[name]

# Tuples
product_catalog = (
    ("Product1", 100),
    ("Product2", 150),
    ("Product3", 200),
)

# Sets
product_categories = {"Electronics", "Clothing", "Home"}

def add_category(category):
    product_categories.add(category)

def remove_category(category):
    if category in product_categories:
        product_categories.remove(category)

# Combining Collections
def generate_report():
    sorted_products = sorted(product_details.items(), key=lambda x: x[1]["price"])
    for name, details in sorted_products:
        print(f"{name}: {details['price']}")

def find_products_in_price_range(min_price, max_price):
    result = {name for name, details in product_details.items() if min_price <= details["price"] <= max_price}
    return result

# Example Usage
add_product("Product4")
remove_product("Product2")
update_product("Product1", "UpdatedProduct1")

add_product_detail("Product4", 12, 250)
update_product_detail("Product3", price=180)
delete_product_detail("Product2")

print("Product catalog:", product_catalog)
add_category
