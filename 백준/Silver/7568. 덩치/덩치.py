import sys
input = sys.stdin.readline
n = int(input())
dun = []
for i in range(n):
    dun.append(list(map(int, input().split())))
for i in range(n):
    a=1
    for j in range(n):
        if dun[i][0]<dun[j][0] and dun[i][1]<dun[j][1]:
            a+=1
    print(a, end=" ")