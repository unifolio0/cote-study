import sys
input = sys.stdin.readline
n = int(input())
square = [i**2 for i in range(1, int(50000**0.5)+1)]
if int(n**0.5)==n**0.5:
    print(1)
    exit(0)
for i in range(int(n**0.5)):
    for j in range(i, int(n**0.5)):
        if square[i]+square[j]==n:
            print(2)
            exit(0)
for i in range(int(n**0.5)):
    for j in range(i, int(n**0.5)):
        for k in range(j, int(n**0.5)):
            if square[i]+square[j]+square[k]==n:
                print(3)
                exit(0)
print(4)