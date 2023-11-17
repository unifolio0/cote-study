A, B = input().split()
c = int(input())
a = int(A)
b = int(B)
if (b+c)>=60:
    a += (b+c)//60
    if a>=24:
        a=a%24
    b = (b+c)%60
else:
    b = b+c
print(a, b)