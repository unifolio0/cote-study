import sys
input = sys.stdin.readline
n = int(input())
re = [0]*(n+1)
for i in range(2, n+1):
    re[i] = re[i-1]+1
    if i%3==0:
        re[i] = min(re[i], re[i//3]+1)
    if i%2==0:
        re[i] = min(re[i], re[i//2]+1)
print(re[n])