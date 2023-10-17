import sys
input = sys.stdin.readline
from collections import Counter
n, m = map(int, input().split())
a1 = []
a2 = []
for i in range(n):
    a1.append(input().replace("\n", ""))
for i in range(m):
    a2.append(input().replace("\n", ""))
op = a1 + a2
re = Counter(op)
a3 = [i for i in re if re[i]>1]
a3.sort()
print(len(a3))
for i in a3:
    print(i)