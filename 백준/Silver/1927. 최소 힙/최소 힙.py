import sys
import heapq
fastinput = sys.stdin.readline
N = int(fastinput())
heap = []
for i in range(N):
    x = int(fastinput())
    if x != 0:
        heapq.heappush(heap, x)
    else:
        if heap:
            print(heapq.heappop(heap))
        else:
            print(0)