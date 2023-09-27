t = int(input())
for i in range(t):
    n = int(input())
    num = [[0 for k in range(n)] for j in range(n)]
    r = 0
    c = 0
    a = 1
    z = 0
    while True:
        if z == 0:
            num[r][c] = a
            a+=1
            if c<n-1 and num[r][c+1] ==0:
                c+=1
            else:
                r+=1
                z=1
        elif z == 1:
            num[r][c] = a
            a+=1
            if r<n-1 and num[r+1][c] == 0:
                r+=1
            else:
                c-=1
                z=2
        elif z == 2:
            num[r][c] = a
            a+=1
            if c>0 and num[r][c-1] == 0:
                c-=1
            else:
                r-=1
                z=3
        elif z == 3:
            num[r][c] = a
            a+=1
            if num[r-1][c] == 0:
                r-=1
            else:
                c+=1
                z=0
        if a>n**2:
            print("#{}".format(i+1))
            for q in num:
                print(*q)
            break