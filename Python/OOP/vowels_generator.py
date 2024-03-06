def vowels(word):
    for i in range(0, len(word)):
        if word[i].lower() in ['a','e','i','o','u']:
            yield word[i]

for v in vowels('Jane'):
    print(v)

# iterator = vowels('Joanna Cecilia da Silva Santos')
# print(iterator.__next__())
# print(iterator.__next__())