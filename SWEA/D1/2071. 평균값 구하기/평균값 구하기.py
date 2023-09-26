n = int(input())
for i in range(n):
    a = list(map(int, input().split()))
    print("#{} {}".format(i+1, round(sum(a)/10)))