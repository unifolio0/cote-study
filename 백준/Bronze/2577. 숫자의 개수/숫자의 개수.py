import sys
input = sys.stdin.readline
n = 1
for i in range(3):
    n*=int(input())
a = str(n)
b = list(a)
for i in range(10):
    print(b.count(str(i)))