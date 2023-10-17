import sys
input = sys.stdin.readline
n, m = map(int, input().split())
dic = {}
for i in range(n):
    a = input().rsplit()
    dic[a[0]] = a[1]
for i in range(m):
    print(dic[input().replace("\n", "")])