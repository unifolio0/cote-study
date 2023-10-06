import sys
input = sys.stdin.readline
while True:
    n = int(input())
    if n==0:
        break
    a1 = str(n)
    if a1 == a1[::-1]:
        print('yes')
    else:
        print('no')