# enhanced_inventory_management.py

import threading
import time
import json

class Inventory:
    def __init__(self):
        self.items = {}

    def add_item(self, name, quantity):
        if name in self.items:
            self.items[name] += quantity
        else:
            self.items[name] = quantity

    def remove_item(self, name, quantity):
        if name in self.items and self.items[name] >= quantity:
            self.items[name] -= quantity
            if self.items[name] == 0:
                del self.items[name]
        else:
            print(f"Not enough stock or item '{name}' not found.")

    def check_stock(self, name):
        return self.items.get(name, 0)

    def save_to_file(self, filename):
        try:
            with open(filename, 'w') as file:
                json.dump(self.items, file)
        except IOError as e:
            print(f"Error saving inventory to file: {e}")

    def load_from_file(self, filename):
        try:
            with open(filename, 'r') as file:
                self.items = json.load(file)
        except (IOError, json.JSONDecodeError) as e:
            print(f"Error loading inventory from file: {e}")

    def restocking_alert(self, threshold=5):
        while True:
            for name, quantity in self.items.items():
                if quantity <= threshold:
                    print(f"Restock alert: {name} is low on stock ({quantity} units left).")
            time.sleep(10)  # Check every 10 seconds

# Create an inventory instance and perform operations
inventory = Inventory()
inventory.add_item("item1", 10)
inventory.add_item("item2", 3)
inventory.add_item("item3", 7)

# Save inventory state to a file
inventory.save_to_file("inventory.json")

# Start a thread to periodically check stock levels
restocking_thread = threading.Thread(target=inventory.restocking_alert)
restocking_thread.start()

# Load inventory state from the file
inventory.load_from_file("inventory.json")
print("Loaded inventory:", inventory.items)
