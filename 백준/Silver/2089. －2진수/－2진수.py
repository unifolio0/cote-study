import sys
input = sys.stdin.readline
n = int(input())
re = ''
while True:
    if n%(-2):
        re += '1'
        n=(n//-2)+1
    else:
        re+='0'
        n=n//-2
    if n==0:
        print(re[::-1])
        break