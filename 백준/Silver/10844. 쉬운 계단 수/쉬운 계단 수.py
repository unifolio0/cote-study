import sys
input = sys.stdin.readline
n = int(input())
re = [[0 for i in range(10)] for j in range(n+1)]
re[1] = [0,1,1,1,1,1,1,1,1,1]
for i in range(2, n+1):
    re[i][0] = re[i-1][1]
    for j in range(1,9):
        re[i][j] = (re[i-1][j-1]+re[i-1][j+1])%1000000000
    re[i][9] = re[i-1][8]
print(sum(re[n])%1000000000)