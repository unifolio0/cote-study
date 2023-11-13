import sys
fastinput = sys.stdin.readline
n = fastinput()[:-1].split("-")
a = []
for i in n:
    a.append(sum(map(int, i.split("+"))))
total = a[0]
for i in range(1, len(a)):
    total -= a[i]
print(total)