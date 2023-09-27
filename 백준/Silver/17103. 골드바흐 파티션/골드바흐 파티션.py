import sys
input = sys.stdin.readline
n = 1000001
che = [True]*n
for i in range(2, int(n**0.5)+1):
    if che[i] == True:
        for j in range(i+i, n, i):
            che[j] = False
che[1]=False
che[0]=False
a = int(input())
for i in range(a):
    n = int(input())
    cou = 0
    for i in range(2,(n//2)+1):
        if che[i] and che[n-i]:
            cou += 1
    print(cou)