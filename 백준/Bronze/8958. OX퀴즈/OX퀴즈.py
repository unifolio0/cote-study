import sys
input = sys.stdin.readline
n = int(input())
for i in range(n):
    ans = list(input())
    c = 0
    re = 0
    for j in range(len(ans)):
        if ans[j] == 'O':
            c+=1
            re+=c
        else:
            c=0
    print(re)