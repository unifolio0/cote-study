import sys
from collections import deque
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
def bfs(x, y):
    graph[x][y] = 0
    dx = [0,0,-1,1]
    dy = [1,-1,0,0]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1:
            bfs(nx, ny)

T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())
    count = 0
    graph = [[0 for j in range(M)] for i in range(N)]
    for i in range(K):
        x, y = map(int, input().split())
        graph[y][x] = 1
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                count += 1
                bfs(i, j)
    print(count)