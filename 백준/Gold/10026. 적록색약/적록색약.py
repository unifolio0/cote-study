import sys
from collections import deque
fastinput = sys.stdin.readline
N = int(fastinput())
picture = []
visit = [[0 for i in range(N)] for j in range(N)]
for i in range(N):
    picture.append(list(input()))
count = 0
def bfs(i, j):
    q = deque()
    q.append((i, j))
    while q:
        x, y = q.popleft()
        dx = [0,0,-1,1]
        dy = [1,-1,0,0]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and visit[nx][ny] == 0 and picture[nx][ny] == picture[x][y]:
                visit[nx][ny] = 1
                q.append((nx, ny))
for i in range(N):
    for j in range(N):
        if visit[i][j] == 0:
            bfs(i, j)
            count += 1
print(count, end = " ")
for i in range(N):
    for j in range(N):
        if picture[i][j] == 'G':
            picture[i][j] = 'R'
visit = [[0 for i in range(N)] for j in range(N)]
count = 0
for i in range(N):
    for j in range(N):
        if visit[i][j] == 0:
            bfs(i, j)
            count += 1
print(count)