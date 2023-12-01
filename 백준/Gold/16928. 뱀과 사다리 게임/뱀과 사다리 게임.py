import sys
from collections import deque
fastinput = sys.stdin.readline
N, M = map(int, fastinput().split())
ladder = {}
snake = {}
for i in range(N):
    x, y = map(int, fastinput().split())
    ladder[x] = y
for j in range(M):
    u, v = map(int, fastinput().split())
    snake[u] = v
q = deque([1])
game = [0]*101
visit = [0]*101
visit[1] = 1
while q:
    can = q.popleft()
    if can == 100:
        print(game[can])
        break
    for i in range(1,7):
        nx = can + i
        if nx <= 100:
            if nx in ladder.keys():
                nx = ladder[nx]
            if nx in snake.keys():
                nx = snake[nx]
            if visit[nx] == 0:
                game[nx] = game[can] + 1
                #print(f"nx:{nx}, game[can]:{game[can]}, game[nx]:{game[nx]}")
                visit[nx] = 1
                q.append(nx)