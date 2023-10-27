import sys
input = sys.stdin.readline
T = int(input())
for t in range(T):
    p = list(input()[:-1])
    n = int(input())
    if n>0:
        x = list(map(int, input()[1:-2].split(",")))
        r = False
        for i in p:
            if i=='R':
                r = not r
            else:
                if x:
                    if r:
                        x.pop()
                    else:
                        x.pop(0)
                else:
                    print("error")
                    break
        else:
            print("[",end="")
            if r:
                if x:
                    print(f"{x[-1]}",end="")
                for i in range(len(x)-2,-1,-1):
                    print(f",{x[i]}", end="")
            else:
                if x:
                    print(f"{x[0]}",end="")
                for i in range(1, len(x)):
                    print(f",{x[i]}", end="")
            print("]")
    else:
        x = input()
        for i in p:
            if i=='D':
                print("error")
                break
        else:
            print("[]")