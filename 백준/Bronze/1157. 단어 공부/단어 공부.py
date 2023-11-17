a = list(input().upper())
b = list(set(a))
cou = []
z=0
for i in b:
    cou.append(a.count(i))
if cou.count(max(cou))>1:
    print("?")
else:
    print(b[cou.index(max(cou))])