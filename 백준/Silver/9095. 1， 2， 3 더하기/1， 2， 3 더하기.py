import sys
input = sys.stdin.readline
n = int(input())
re = [0]*12
re[1] = 1
re[2] = 2
re[3] = 4
a, b, c = 0, 1, 2
for i in range(4, 12):
    re[i] = re[i-1] + a + b + c
    a, b, c = b, c, a+b+c
for i in range(n):
    print(re[int(input())])