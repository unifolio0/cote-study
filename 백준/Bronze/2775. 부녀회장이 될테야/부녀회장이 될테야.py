import sys
input = sys.stdin.readline
apt = [[i+1 for i in range(14)] for j in range(15)]
for i in range(1, 15):
    for j in range(14):
        apt[i][j] = sum(apt[i-1][0:j+1])
n = int(input())
for i in range(n):
    k = int(input())
    p = int(input())
    print(apt[k][p-1])