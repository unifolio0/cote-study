import sys
input = sys.stdin.readline
n = int(input())
p = list(map(int, input().split()))
re = [0]*(n+1)
re[1] = p[0]
for i in range(2, n+1):
    re[i] = min([x+y for x, y in zip(re[:i], p[i-1::-1])])
print(re[n])