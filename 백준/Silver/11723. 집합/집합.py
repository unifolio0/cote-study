import sys
input = sys.stdin.readline
n = int(input())
s = [0 for i in range(20)]
for i in range(n):
    ans = input().split()
    if ans[0] == "add":
        s[int(ans[1])-1] += 1
    elif ans[0] == "remove":
        if s[int(ans[1])-1] != 0:
            s[int(ans[1])-1] -= 1
    elif ans[0] == "check":
        if s[int(ans[1])-1] != 0:
            print(1)
        else:
            print(0)
    elif ans[0] == "toggle":
        if s[int(ans[1])-1] != 0:
            s[int(ans[1])-1] -= 1
        else:
            s[int(ans[1])-1] += 1
    elif ans[0] == "all":
        s = [1 for i in range(20)]
    elif ans[0] == "empty":
        s = [0 for i in range(20)]