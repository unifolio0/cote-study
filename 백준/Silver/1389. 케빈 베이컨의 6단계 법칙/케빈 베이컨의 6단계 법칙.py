import sys
from collections import deque
fastinput = sys.stdin.readline
N, M = map(int, fastinput().split())
friend = [[] for i in range(N)]
for i in range(M):
    A, B = map(int, fastinput().split())
    friend[A-1].append(B-1)
    friend[B-1].append(A-1)
q = deque()
def bfs():
    min = 0
    minTotal = int(1e9)
    for i in range(N):
        q.append(i)
        check = [0]*(N)
        check[i] = 1
        total = 0
        while q:
            x = q.popleft()
            for k in friend[x]:
                if check[k] == 0:
                    check[k] = check[x] + 1
                    total += check[x]
                    q.append(k)
        if minTotal > total:
            min = i
            minTotal = total
    print(min + 1)
bfs()