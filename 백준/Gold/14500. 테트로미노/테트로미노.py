import sys
fastinput = sys.stdin.readline
N, M = map(int, fastinput().split())
paper = []
for i in range(N):
    paper.append(list(map(int, input().split())))
dx = [0,0,-1,1]
dy = [1,-1,0,0]
visited = [[0 for i in range(M)] for j in range(N)]
sumMax = 0
#ㅡ,ㅁ,L,Z 모양 처리
def dfs(i, j, sum, co):
    global sumMax
    sum += paper[i][j]
    if co == 3:
        sumMax = max(sumMax, sum)
        return
    for k in range(4):
        nx = i + dx[k]
        ny = j + dy[k]
        if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == 0:
            visited[nx][ny] = 1
            dfs(nx, ny, sum, co + 1)
            visited[nx][ny] = 0
def ex(i, j):
    global sumMax
    sum = paper[i][j]
    for k in range(4):
        if 0 <= i + dx[k] < N and 0 <= j + dy[k] < M:
            sum += paper[i + dx[k]][j + dy[k]]
    for k in range(4):
        if 0 <= i + dx[k] < N and 0 <= j + dy[k] < M:
            sumMax = max(sumMax, sum - paper[i + dx[k]][j + dy[k]])
        else:
            sumMax = max(sum, sumMax)
        
for i in range(N):
    for j in range(M):
        visited[i][j] = 1
        dfs(i, j, 0, 0)
        visited[i][j] = 0
        ex(i, j)
print(sumMax)