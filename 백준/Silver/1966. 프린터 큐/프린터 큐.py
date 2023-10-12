import sys
input = sys.stdin.readline
T = int(input())
for t in range(T):
    n, m = map(int, input().split())
    document = list(map(int, input().split()))
    idx = [i for i in range(n)]
    count = 0
    while True:
        if document[0] == max(document):
            if idx[0] == m:
                print(count+1)
                break
            else:
                del document[0]
                del idx[0]
                count += 1
        else:
            document.append(document[0])
            idx.append(idx[0])
            del document[0]
            del idx[0]