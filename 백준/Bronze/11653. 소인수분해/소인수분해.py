import sys
input = sys.stdin.readline
N = int(input())
a=2
while(a<=N):
    if N%a==0:
        print(a)
        N/=a
    else:
        a+=1