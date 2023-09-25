import sys
import math
input = sys.stdin.readline
n = int(input())
for i in range(n):
    a, b = map(int, input().split())
    c=math.gcd(a, b)
    print(c*(a//c)*(b//c))