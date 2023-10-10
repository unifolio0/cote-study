import sys
from collections import Counter
def round_m(num):
    if num>=0:
        a = num - int(num)
        if a>=0.5:
            return int(num)+1
        else:
            return int(num)
    else:
        a = num - int(num)
        if a<=-0.5:
            return int(num)-1
        else:
            return int(num)
    
input = sys.stdin.readline
n = int(input())
a = []
for i in range(n):
    a.append(int(input()))
a.sort()
b = Counter(a)
k = max(b.values())
d = []
for i in b:
    if k==b[i]:
        d.append(i)
if len(d)==1:
    o = d[0]
else:
    o = d[1]
print(round_m(sum(a)/n))
print(a[n//2])
print(o)
print(a[n-1]-a[0])