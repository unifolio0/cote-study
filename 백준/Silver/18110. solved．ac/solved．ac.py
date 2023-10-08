import sys
input = sys.stdin.readline
def round_e(num):
    e = num - int(num)
    if e>=0.5:
        return int(num) + 1
    else:
        return int(num)

n = int(input())
if n==0:
    print(0)
else:
    com = []
    for i in range(n):
        com.append(int(input()))
    com.sort()
    x = round_e(n*0.15)
    print(round_e(sum(com[x:n-x])/(n-(2*x))))