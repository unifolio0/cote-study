A, B, C = input().split()
a = int(A)
b = int(B)
c = int(C)
if a==b==c:
    a=10000 + (a*1000)
elif a==b or c==a:
    a = 1000 + (a*100)
elif b==c:
    a = 1000 + (b*100)
else:
    if a>b:
        if a>c:
            a = a*100
        else:
            a = c*100
    else:
        if b>c:
            a = b *100
        else:
            a = c*100
print(a)