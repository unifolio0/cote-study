import sys
input = sys.stdin.readline
t = int(input())
for i in range(t):
    h, w, n = map(int, input().split())
    a = n % h
    b = n // h + 1
    if a == 0:
        a = h
        b -= 1
    if b<10:
        re = str(a) + str('0') + str(b)
    else:
        re = str(a) + str(b)
    print(re)