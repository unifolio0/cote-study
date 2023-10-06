import sys
input = sys.stdin.readline
nums = list(map(int, input().split()))
num = [i**2 for i in nums]
print(sum(num)%10)