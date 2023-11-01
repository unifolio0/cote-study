import sys
input = sys.stdin.readline
from operator import itemgetter, attrgetter
N = int(input())
timeList = []
for n in range(N):
    startTime, endTime = map(int, input().split())
    timeList.append([startTime, endTime])
timeList = sorted(timeList, key=itemgetter(1,0))
stack = []
stack.append(timeList[0])
for i in range(1, len(timeList)):
    if stack[-1][1]<=timeList[i][0]:
        stack.append(timeList[i])
print(len(stack))