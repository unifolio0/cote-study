import sys
from collections import deque
fastinput = sys.stdin.readline
n, m = map(int, fastinput().split())
graph = []
visit = [[0 for i in range(m)] for j in range(n)]
for _ in range(n):
    graph.append(list(map(int, input().split())))
for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            x, y = i, j
            graph[i][j] = 0
            visit[x][y] = 1
q = deque([(x, y)])
while q:
    x, y = q.popleft()
    dx = [0,0,-1,1]
    dy = [1,-1,0,0]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] != 0 and visit[nx][ny] == 0:
            graph[nx][ny] = graph[x][y] + 1
            visit[nx][ny] = 1
            q.append((nx, ny))
for i in range(n):
    for j in range(m):
        if visit[i][j] == 0 and graph[i][j] != 0:
            graph[i][j] = -1
for i in range(n):
    for j in range(m):
        print(graph[i][j], end=" ")
    print()