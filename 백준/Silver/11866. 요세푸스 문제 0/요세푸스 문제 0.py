import sys
input = sys.stdin.readline
n, k = map(int, input().split())
yo = [i for i in range(1, n+1)]
re = []
c = 0
while yo:
    c = (c+k)%len(yo)-1
    if c==-1:
        c=len(yo)-1
    re.append(yo.pop(c))
print("<{}".format(re[0]), end = "")
for i in range(1, len(re)):
    print(", {}".format(re[i]), end="")
print(">")