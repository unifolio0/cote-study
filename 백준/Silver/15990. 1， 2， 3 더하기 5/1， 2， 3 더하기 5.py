import sys
input = sys.stdin.readline
n = int(input())
re = [[0 for i in range(3)] for j in range(100001)]
re[1][0] = 1
re[2][1] = 1
re[3][0] = 1
re[3][1] = 1
re[3][2] = 1
for i in range(4, 100001):
    re[i][0] = (re[i-1][1] + re[i-1][2])%1000000009
    re[i][1] = (re[i-2][0] + re[i-2][2])%1000000009
    re[i][2] = (re[i-3][1] + re[i-3][0])%1000000009
for i in range(n):
    k = int(input())
    print((re[k][0]+re[k][1]+re[k][2])%1000000009)