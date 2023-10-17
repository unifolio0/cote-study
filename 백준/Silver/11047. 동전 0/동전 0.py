import sys
input = sys.stdin.readline
n, k = map(int, input().split())
coin = []
for i in range(n):
    a = int(input())
    if a<=k:
        coin.append(a)
count = 0
coin.sort(reverse=True)
i = 0
while k!=0:
    if coin[i]<=k:
        count+=k//coin[i]
        k-=coin[i]*(k//coin[i])
        continue
    i+=1
print(count)