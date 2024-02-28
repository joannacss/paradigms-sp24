# class Car: 
	
# 	# init method or constructor 
# 	def __init__(self,a):
# 		self.model = "Unknown"
# 		self.color = "colorless"

# 	def __init__(self, model, color): 
# 		self.model = model 
# 		self.color = color 

	
		
# 	def show(self): 
# 		print("Model is", self.model ) 
# 		print("color is", self.color ) 

# 	def __str__(self):
# 		return f"{self.model} ({self.color})"
		
# # both objects have different self which 
# # contain their attributes 
# # audi = Car("audi a4", "blue") 
# # ferrari = Car("ferrari 488", "green") 
# car = Car('a')
# # audi.show()	 	# same output as Car.show(audi) 
# # ferrari.show()  # same output as Car.show(ferrari) 

# print(audi)
# print(ferrari)
# print(car)

class MyClass:
    def __init__(self, arg1, arg2):
        self.arg1 = arg1
        self.arg2 = arg2
    
    def __init__(self, arg1):
        self.arg1 = arg1
        self.arg2 = None
        
obj1 = MyClass(10, 20)
obj2 = MyClass(30)