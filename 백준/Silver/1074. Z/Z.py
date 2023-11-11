import sys
import heapq
fastinput = sys.stdin.readline
N, r, c = map(int, fastinput().split())
count = 0
def zsearch(i, j):
    global count
    if i == r and j == c:
        print(count)
    elif i == r and j+1 == c:
        print(count+1)
    elif i+1 == r and j == c:
        print(count+2)
    else:
        print(count+3)

def zmapsearch(n, i, j):
    global count
    if i <= r < n + i and j <= c < n + j:
        if n == 2:
            zsearch(i, j)
            return
        else:
            zmapsearch(n//2, i, j)
            zmapsearch(n//2, i, n//2 + j)
            zmapsearch(n//2, n//2 + i, j)
            zmapsearch(n//2, n//2 + i, n//2 + j)
    else:
        count += n**2
zmapsearch(2**N, 0, 0)