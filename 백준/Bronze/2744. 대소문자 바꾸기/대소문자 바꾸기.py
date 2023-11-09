x = input()
str = ""
for i in x:
    if i.islower():
        str += i.upper()
    else:
        str += i.lower()
print(str)