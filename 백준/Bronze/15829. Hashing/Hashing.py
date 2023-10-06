import sys
input = sys.stdin.readline
n = int(input())
ha = list(input().replace('\n', ''))
sum = 0
for i in range(len(ha)):
    sum = (sum + ((ord(ha[i])-ord('a')+1)*(31**i))) % 1234567891
print(sum)