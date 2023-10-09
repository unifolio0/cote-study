import sys
input = sys.stdin.readline
n = int(input())
st1 = [i+1 for i in range(n)]
while True:
    if len(st1)>1:
        if len(st1)%2 == 0:
            st2 = [st1[i] for i in range(1, len(st1), 2)]
            st1 = st2
        else:
            st2 = [st1[i] for i in range(3, len(st1), 2)]
            st2.append(st1[1])
            st1 = st2
    else:
        print(st1[0])
        break