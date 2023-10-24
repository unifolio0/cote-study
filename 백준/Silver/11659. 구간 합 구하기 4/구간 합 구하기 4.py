import sys
input = sys.stdin.readline
n, m = map(int, input().split())
a = list(map(int, input().split()))
prefix_sum = [0]
t = 0
for i in range(n):
    t+=a[i]
    prefix_sum.append(t)
for i in range(m):
    i, j = map(int, input().split())
    print(prefix_sum[j]-prefix_sum[i-1])