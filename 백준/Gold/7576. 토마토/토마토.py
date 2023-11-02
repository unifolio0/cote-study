import sys
from collections import deque
M, N = map(int, sys.stdin.readline().split())
box = []
for i in range(N):
    box.append(list(map(int, input().split())))
queue = deque()
st = 0
ed = 0
for i in range(N):
    for j in range(M):
        if box[i][j] == 1:
            queue.append((i,j))
            st += 1
ed = st
st = 0
count = 0
def bfs():
    global ed, st, count
    co = 0
    dx = [0,0,-1,1]
    dy = [1,-1,0,0]
    while queue:
        x, y = queue.popleft()
        if ed == st:
            ed = co
            st = 1
            co = 0
            count += 1
        else:
            st += 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and box[nx][ny] == 0:
                box[nx][ny] = 1
                queue.append((nx, ny))
                co+=1
    for i in range(N):
        for j in range(M):
            if box[i][j] == 0:
                return -1
    return count
print(bfs())