import sys
input = sys.stdin.readline
n = int(input())
for i in range(1, n):
    n *= i
if n == 0: 
    n=1
i=0
while True:
    if n%10==0:
        i+=1
        n=n//10
    else:
        break
print(i)