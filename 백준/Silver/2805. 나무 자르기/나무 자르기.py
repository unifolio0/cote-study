import sys
fastinput = sys.stdin.readline
N, M = map(int, fastinput().split())
trees = sorted(list(map(int, fastinput().split())), reverse=True)
low = 0
high = trees[0]
while low<=high:
    mid = (low + high) // 2
    sum = 0
    for j in trees:
        if mid<j:
            sum+=j-mid
        else:
            break
    if sum<M:
        high = mid - 1
    else:
        low = mid + 1
print(high)