import sys
from collections import deque
fastinput = sys.stdin.readline
N = int(fastinput())
paper = []
for i in range(N):
    paper.append(list(map(int, input().split())))
def check(n, x, y, m):
    if n != 1:
        for i in range(x, x+n):
            for j in range(y, y+n):
                if paper[i][j] != m:
                    return check(n//2, x, y, m) + check(n//2, n//2 + x, y, m) + check(n//2, x, n//2 + y, m) + check(n//2, n//2+x, n//2+y, m)
    if paper[x][y] == m:
        return 1
    else:
        return 0
print(check(N, 0, 0, 0))
print(check(N, 0, 0, 1))