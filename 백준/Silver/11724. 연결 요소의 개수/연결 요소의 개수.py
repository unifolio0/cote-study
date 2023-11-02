import sys
from collections import deque
fastInput = sys.stdin.readline
N, M = map(int, fastInput().split())
graph = [[] for i in range(N+1)]
visit = [0]*(N+1)
for _ in range(M):
    u, v = map(int, fastInput().split())
    graph[u] += [v]
    graph[v] += [u]
def bfs(i):
    queue = deque()
    queue.append(i)
    while queue:
        x = queue.popleft()
        for k in graph[x]:
            if visit[k] == 0:
                visit[k] = 1
                queue.append(k)
count = 0
for i in range(1, N+1):
    if visit[i] == 0:
        visit[i] = 1
        bfs(i)
        count += 1
print(count)