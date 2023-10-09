import sys
from collections import Counter
input = sys.stdin.readline
n = int(input())
a = sorted(list(map(int, input().split())))
m = int(input())
nums = list(map(int, input().split()))
dic = Counter(a)
for i in nums:
    st = 0
    en = n-1
    while st<=en:
        mid = (st+en)//2
        if a[mid]==i:
            print(dic[i], end=" ")
            break
        elif a[mid]>i:
            en = mid-1
        else:
            st = mid+1
    else:
        print(0, end=" ")