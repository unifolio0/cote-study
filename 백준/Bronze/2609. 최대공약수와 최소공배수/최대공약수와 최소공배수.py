import sys
import math
input = sys.stdin.readline
a, b = map(int, input().split())
c=math.gcd(a, b)
print(c)
print(c*(a//c)*(b//c))