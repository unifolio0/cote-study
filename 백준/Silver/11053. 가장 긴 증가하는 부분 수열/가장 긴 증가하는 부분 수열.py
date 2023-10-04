import sys
input = sys.stdin.readline
n = int(input())
nums = list(map(int, input().split()))
st = [1]*n
for i in range(1, n):
    for j in range(i):
        if nums[j]<nums[i]:
            st[i] = max(st[j]+1, st[i])
print(max(st))