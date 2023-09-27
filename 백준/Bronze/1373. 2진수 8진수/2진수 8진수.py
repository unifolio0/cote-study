import sys
input = sys.stdin.readline
n = input().replace('\n', '')
print(oct(int(n,2))[2:])