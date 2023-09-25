str = input()
ap = ord('a')

for i in range(26):
    count = str.count(chr(ap+i))
    if count != 0:
        ch = str.index(chr(ap+i))
    else:
        ch = -1
    print(ch, end=" ")