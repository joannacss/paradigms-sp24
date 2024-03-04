class int:
    def __init__(self, x):
        self.x = x

    def __add__(self, b):
        return self.x - b.x






















a = int(1)
b = int(2)
print(a + b)