import sys
import math
input = sys.stdin.readline
n = int(input())
for i in range(n):
    a = list(map(int, input().split()))
    sum = 0
    for i in range(1, len(a)-1):
        for j in range(i+1, len(a)):
            sum += math.gcd(a[i], a[j])
    print(sum)