import sys
input = sys.stdin.readline
n = input().replace('\n', '')
print(bin(int(n,8))[2:])