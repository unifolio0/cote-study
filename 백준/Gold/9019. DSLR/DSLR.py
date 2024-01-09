import sys
from collections import deque
fastInput = sys.stdin.readline
T = int(fastInput())

def bfs():
    A, B = map(int, fastInput().rsplit())
    visited[A] = ""
    q.append(A)
    while q:
        y = q.popleft()
        if y == B:
            print(visited[y])
            return
        d = (y * 2) % 10000
        if "-" == visited[d]:
            visited[d] = visited[y] + 'D'
            q.append(d)
        s = y - 1
        if s < 0:
            s = 9999
        if "-" == visited[s]:
            visited[s] = visited[y] + 'S'
            q.append(s)
        l = ((y % 1000) * 10) + (y // 1000)
        if "-" == visited[l]:
            visited[l] = visited[y] + 'L'
            q.append(l)
        r = (y // 10) + ((y % 10) * 1000)
        if "-" == visited[r]:
            visited[r] = visited[y] + 'R'
            q.append(r)
for _ in range(T):
    q = deque()
    visited = ["-" for i in range(10001)]
    bfs()
