import sys
from collections import deque
fastinput = sys.stdin.readline
M, N, H = map(int, fastinput().split())
box = [[] for i in range(H)]
for i in range(H):
    for j in range(N):
        box[i].append(list(map(int, input().split())))
q = deque()
d_end = 0
for i in range(len(box)):
    for j in range(len(box[i])):
        for k in range(len(box[i][j])):
            if box[i][j][k] == 1:
                q.append((i,j,k))
                d_end += 1
dx = [0,0,-1,1,0,0]
dy = [1,-1,0,0,0,0]
dz = [0,0,0,0,1,-1]
day = 0
d_st = 0
count = 0
while q:
    z, y, x = q.popleft()
    for i in range(6):
        nx, ny, nz = x + dx[i], y + dy[i], z + dz[i]
        if 0 <= nx < M and 0 <= ny < N and 0 <= nz < H and box[nz][ny][nx] == 0:
            q.append((nz, ny, nx))
            box[nz][ny][nx] = 1
            count += 1
    d_st += 1
    if d_st == d_end:
        d_st = 0
        d_end = count
        count = 0
        day += 1
def check(day):
    for i in range(len(box)):
        for j in range(len(box[i])):
            for k in range(len(box[i][j])):
                if box[i][j][k] == 0:
                    return -1
    return day - 1
print(check(day))