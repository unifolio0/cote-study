import sys
input = sys.stdin.readline
T = int(input())
for t in range(T):
    n = int(input())
    dic = {}
    for i in range(n):
        a = input().rsplit()
        if a[1] in dic:
            dic[a[1]]+=1
        else:
            dic[a[1]]=1
    sum = 1
    for i in dic.keys():
        sum *= dic[i]+1
    print(sum-1)