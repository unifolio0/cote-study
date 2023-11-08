import sys
from collections import deque
fastinput = sys.stdin.readline
N, K = map(int, fastinput().split())
MAX = 100001
visit = [0]*MAX
def bfs():
    q = deque()
    q.append(N)
    while q:
        x = q.popleft()
        if x == K:
            print(visit[x])
            return
        next = [x+1, x-1, 2*x]
        for i in next:
            if 0 <= i < MAX and visit[i] == 0:
                visit[i] = visit[x] + 1
                q.append(i)
bfs()