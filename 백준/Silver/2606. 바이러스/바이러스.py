import sys
input = sys.stdin.readline
com = int(input())
n = int(input())
graph = {}
re = []
count = 0
for i in range(n):
    i, j = map(int, input().split())
    if i in graph:
        graph[i].append(j)
    else:
        graph[i] = []
        graph[i].append(j)
    if j in graph:
        graph[j].append(i)
    else:
        graph[j] = []
        graph[j].append(i)
re.append(1)
q = []
while n!=0:
    k = re.pop(0)
    q.append(k)
    for i in graph[k]:
        if (i not in q) and (i not in re):
            re.append(i)
            count+=1
    if len(re)==0:
        break
print(count)