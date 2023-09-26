import sys
import math
input = sys.stdin.readline
n, s = map(int,input().split())
a = list(map(int, input().split()))
b = [s - i for i in a]
print(math.gcd(*b))