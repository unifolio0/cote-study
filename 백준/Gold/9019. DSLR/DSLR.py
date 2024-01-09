from collections import deque
from sys import stdin
input = stdin.readline

def BFS(A, B) :
    visited = ['-'] * 10000
    queue = deque([A])
    visited[A] = ''
    while queue :
        val = queue.popleft()
        next_val = [
            (val * 2) % 10000,
            [val - 1, 9999][val == 0],
            (val % 1000) * 10 + val // 1000,
            (val % 10) * 1000 + val // 10
        ]
        for idx in range(4) :
            if next_val[idx] == B : return visited[val] + 'DSLR'[idx]
            if visited[next_val[idx]] == '-' :
                visited[next_val[idx]] = visited[val] + 'DSLR'[idx]
                queue.append(next_val[idx])

if __name__ == "__main__" :
    for _ in range(int(input())) :
        A, B = map(int, input().split())
        print(BFS(A, B))