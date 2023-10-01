import sys
input = sys.stdin.readline
a, b = map(int, input().split())
m = int(input())
nums = list(map(int, input().split()))
res = 0
for i in range(m):
    res += nums[i]*(a**(m-i-1))
re = []
while True:
    re.append(res%b)
    res//=b
    if res<b:
        re.append(res)
        break
re.reverse()
print(*re)