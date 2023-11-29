import sys
from collections import deque
fastinput = sys.stdin.readline
N = int(fastinput())
ans = abs(100 - N)
M = int(fastinput())
if M:
    buttons = list(fastinput().split())
else:
    buttons = []
for i in range(1000001):
    for k in str(i):
        if k in buttons:
            break
    else:
        ans = min(ans, len(str(i)) + abs(N - i))
print(ans)