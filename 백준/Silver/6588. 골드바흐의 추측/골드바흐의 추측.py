import sys
input = sys.stdin.readline
n = 1000001
che = [True]*n
for i in range(2, int(n**0.5)+1):
    if che[i] == True:
        for j in range(i+i, n, i):
            che[j] = False

while True:
    n = int(input())
    if n == 0:
        break
    for i in range(3,(n//2)+1, 2):
        if che[i] and che[n-i]:
            print("{} = {} + {}".format(n, i, n-i))
            break
    else:
        print("Goldbach's conjecture is wrong.")