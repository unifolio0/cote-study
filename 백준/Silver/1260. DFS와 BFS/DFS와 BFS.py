import sys
input = sys.stdin.readline
N, M, V = map(int, input().split())
graph = [[] for i in range(N+1)]
visit = [0]*(N+1)
for m in range(M):
    i, j = map(int, input().split())
    graph[i] += [j]
    graph[j] += [i]
for i in range(N+1):
    graph[i].sort()

def dfs(v):
    visit[v] = 1
    print(v, end=" ")
    for i in graph[v]:
        if visit[i] == 0:
            dfs(i)

def bfs(v):
    Q = []
    Q.append(v)
    visit[v] = 1
    while Q:
        vis = Q.pop(0)
        for i in graph[vis]:
            if visit[i] == 0:
                Q.append(i)
                visit[i] = 1
        print(vis, end=" ")

dfs(V)
print()
visit = [0]*(N+1)
bfs(V)