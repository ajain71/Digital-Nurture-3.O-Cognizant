# dynamic_order_processing.py

from abc import ABC, abstractmethod

class DiscountStrategy(ABC):
    @abstractmethod
    def apply_discount(self, order_amount):
        pass

class RegularDiscount(DiscountStrategy):
    def apply_discount(self, order_amount):
        return order_amount

class PremiumDiscount(DiscountStrategy):
    def apply_discount(self, order_amount):
        return order_amount * 0.9  # 10% discount

class VIPDiscount(DiscountStrategy):
    def apply_discount(self, order_amount):
        return order_amount * 0.8  # 20% discount

class Order:
    def __init__(self, customer_type, order_amount):
        self.customer_type = customer_type
        self.order_amount = order_amount

    def final_price(self):
        if self.customer_type == "regular":
            discount_strategy = RegularDiscount()
        elif self.customer_type == "premium":
            discount_strategy = PremiumDiscount()
        elif self.customer_type == "vip":
            discount_strategy = VIPDiscount()
        else:
            raise ValueError("Unknown customer type")

        return discount_strategy.apply_discount(self.order_amount)

# Create instances of Order and calculate final prices
order_regular = Order("regular", 100)
order_premium = Order("premium", 200)
order_vip = Order("vip", 300)

# Print final prices after applying discounts
print(f"Final price for regular customer: ${order_regular.final_price():.2f}")
print(f"Final price for premium customer: ${order_premium.final_price():.2f}")
print(f"Final price for VIP customer: ${order_vip.final_price():.2f}")
