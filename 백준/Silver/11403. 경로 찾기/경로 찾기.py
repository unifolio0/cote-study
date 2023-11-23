import sys
from collections import deque
fastinput = sys.stdin.readline
N = int(fastinput())
graph = []
for i in range(N):
    graph.append(list(map(int, input().split())))
q = deque()
def bfs(i):
    q.append(i)
    check = [0]*N
    while q:
        x = q.popleft()
        for j in range(N):
            if graph[x][j] == 1 and check[j] == 0:
                check[j] = 1
                q.append(j)
    graph[i] = check
for i in range(N):
    bfs(i)
for i in graph:
    print(*i)