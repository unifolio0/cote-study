import sys
fastinput = sys.stdin.readline
T = int(fastinput())
for t in range(T):
    M, N, x, y = map(int, input().split())
    i, j = 0, 0
    count = 0
    while x <= M *N:
        if (x - y) % N == 0:
            print(x)
            break
        x += M
    else:
        print(-1)