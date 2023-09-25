a = list(input())
for i in range(len(a)):
    if a[i].isalpha() == 1:
        if a[i].islower() == 1:
            a[i] = chr(((ord(a[i]) - ord('a') + 13)%26)+ord('a'))
        else:
            a[i] = chr(((ord(a[i]) - ord('A') + 13)%26)+ord('A'))
print(''.join(a))