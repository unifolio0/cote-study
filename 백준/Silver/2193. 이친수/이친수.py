import sys
input = sys.stdin.readline
n = int(input())
re = [[0 for i in range(2)] for j in range(n+1)]
re[1] = [0, 1]
for i in range(2, n+1):
    re[i][0] = re[i-1][0] + re[i-1][1]
    re[i][1] = re[i-1][0]
print(sum(re[n]))