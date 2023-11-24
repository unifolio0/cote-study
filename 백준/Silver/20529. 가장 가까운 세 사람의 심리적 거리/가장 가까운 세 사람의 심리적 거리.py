import sys
from collections import deque
fastinput = sys.stdin.readline
T = int(fastinput())
def cal(x, y):
    re = 0
    for i in range(4):
        if (x[i] != y[i]):
            re+=1
    return re
for t in range(T):
    N = int(fastinput())
    mbtis = list(fastinput()[0:-1].split())
    if N > 32:
        print(0)
    else:
        den = 1000
        for i in range(N-2):
            for j in range(i + 1, N-1):
                for k in range(j + 1, N):
                    den = min(den, (cal(mbtis[i], mbtis[j]) + cal(mbtis[k], mbtis[j]) + cal(mbtis[i], mbtis[k])))
        print(den)