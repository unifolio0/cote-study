import sys
from collections import deque
fastinput = sys.stdin.readline
N, M = map(int, fastinput().split())
campus = []
visit = [[0 for i in range(M)] for j in range(N)]
for i in range(N):
    campus.append(list(input()))
for i in range(N):
    for j in range(M):
        if campus[i][j] == 'O':
            campus[i][j] = 0
        if campus[i][j] == 'P':
            campus[i][j] = 1
        if campus[i][j] == 'X':
            campus[i][j] = -1
        if campus[i][j] == 'I':
            x, y = i, j
            campus[i][j] = 0
            visit[i][j] = 1
count = 0
q = deque()
q.append((x, y))
while q:
    x, y = q.popleft()
    dx = [0,0,-1,1]
    dy = [1,-1,0,0]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M and campus[nx][ny] != -1 and visit[nx][ny] == 0:
            visit[nx][ny] = 1
            q.append((nx, ny))
            if campus[nx][ny] == 1:
                count += 1
if count == 0:
    print("TT")
else:
    print(count)