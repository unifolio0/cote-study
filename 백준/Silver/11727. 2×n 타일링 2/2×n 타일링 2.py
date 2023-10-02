import sys
input = sys.stdin.readline
n = int(input())
re = [0]*(n+1)
re[0] = 1
re[1] = 1
for i in range(2, n+1):
    re[i] = (re[i-1]+(re[i-2]*2))%10007
print(re[n])