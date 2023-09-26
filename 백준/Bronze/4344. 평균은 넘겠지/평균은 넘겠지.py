c = int(input())
for i in range(c):
    b = list(map(int, input().split()))
    sum = 0
    for j in range(1, len(b)):
        sum += b[j]
    avg = sum / b[0]
    count=0
    for j in range(1, len(b)):
        if (b[j]>avg):
            count+=1
    pro = count / b[0] * 100
    print(f"{pro:.3f}%")