import sys
import heapq
fastinput = sys.stdin.readline
N = int(fastinput())
heap = []
for i in range(N):
    x = int(fastinput())
    if x == 0:
        if heap:
            print(-1 * heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, -1 * x)