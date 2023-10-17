import sys
input = sys.stdin.readline
n, m = map(int, input().split())
do = {}
gam = {}
for i in range(n):
    a = input()
    do[a] = i+1
    gam[i+1] = a.replace("\n", "")
for i in range(m):
    n = input()
    if n[0].isalpha():
        print(do[n])
    else:
        print(gam[int(n)])