import sys
from collections import deque
input = sys.stdin.readline
N = int(input())
map = []
for _ in range(N):
    map.append(list(input().replace("\n","")))
for i in range(N):
    for j in range(N):
        map[i][j] = int(map[i][j])
visit = [0]*(N*N)
def search(i, j):
    global d_count
    dx = [0,0,-1,1]
    dy = [1,-1,0,0]
    for k in range(4):
        nx = i+dx[k]
        ny = j+dy[k]
        if 0 <= nx < N and 0 <= ny < N and map[nx][ny] == 1 and visit[nx*N+ny] == 0:
            visit[nx*N+ny] = 1
            d_count += 1
            search(nx,ny)
count = 0
c = []
for i in range(N):
    for j in range(N):
        if map[i][j] == 1 and visit[i*N+j] == 0:
            count+=1
            visit[i*N+j] = 1
            d_count = 1
            search(i,j)
            c.append(d_count)
print(count)
c.sort()
for i in c:
    print(i)