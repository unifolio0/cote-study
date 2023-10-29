import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split())
map = []
for i in range(N):
    map.append(list(input().replace("\n", "")))
for i in range(N):
    for j in range(M):
        map[i][j] = int(map[i][j])
q = deque()
q.append((0,0))
dx = [0,0,-1,1]
dy = [1,-1,0,0]
while q:
    x, y = q.popleft()
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if 0 <= nx <= N - 1 and 0 <= ny <= M - 1 and map[nx][ny] == 1:
            map[nx][ny] = map[x][y] + 1
            q.append((nx,ny))
print(map[N-1][M-1])