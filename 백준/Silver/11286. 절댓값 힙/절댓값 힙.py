import sys
import heapq

fastinput = sys.stdin.readline
N = int(fastinput())
heap = []
for i in range(N):
    com = int(fastinput())
    if com == 0:
        if heap:
            print(heapq.heappop(heap)[1])
        else:
            print(0)
    else:
        heapq.heappush(heap, (abs(com), com))