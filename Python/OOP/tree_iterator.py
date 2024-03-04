class Node:
	def __init__(self, value, left, right):
		self.value = value
		self.left = left
		self.right = right
	
	def __str__(self):
		return self.value



class Tree:
	def __init__(self, root):
		self.root = root
		self.visited = set()
		self.to_visit = [root]

	def __iter__(self): # creates the iterable object
		return self

	def __next__(self): # invoked at every iteration
		
		# checks whether there are nodes left to visit
		if self.to_visit:
			node = self.to_visit.pop(0)
			self.visited.add(node)
			if node.left: 
				self.to_visit.append(node.left)
			if node.right: 
				self.to_visit.append(node.right)
			return node

		
		# if we reach this statement
		# there are no more elements to traverse
		raise StopIteration() # stops iteration

e = Node("E", None, None)
d = Node("D", None, None)
c = Node("C", d, e)
b = Node("B", None, None)
a = Node("A", b, c)

for n in Tree(a):
	print(n)
