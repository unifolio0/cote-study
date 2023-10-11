import sys
input = sys.stdin.readline
k, n = map(int, input().split())
lens = []
for i in range(k):
    lens.append(int(input()))
st = 1
en = sum(lens)//n
while st<=en:
    mid = (st+en)//2
    length = 0
    for i in lens:
        length += i//mid
    if length>=n:
        st = mid+1
    else:
        en = mid-1
print(en)