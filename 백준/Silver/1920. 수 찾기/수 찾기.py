import sys
input = sys.stdin.readline
n = int(input())
a = sorted(list(map(int, input().split())))
m = int(input())
nums = list(map(int, input().split()))
for i in nums:
    st = 0
    en = n-1
    while st<=en:
        mid = (st+en)//2
        if a[mid] < i:
            st = mid + 1
        elif a[mid] > i:
            en = mid - 1
        else:
            print(1)
            break
    else:
        print(0)