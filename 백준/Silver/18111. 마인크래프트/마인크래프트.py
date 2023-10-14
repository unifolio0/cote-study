import sys
input = sys.stdin.readline
n, m, b = map(int, input().split())
ground = {}
for i in range(n):
    a = list(map(int, input().split()))
    for i in a:
        if i in ground:
            ground[i] += 1
        else:
            ground[i] = 1
pre_time = 6.4*(10**7)
hei = 0
for i in range(min(ground.keys()), max(ground.keys())+1):
    up = 0
    down = 0
    time = 0
    for j in ground.keys():
        if i == j:
            continue
        else:
            if i > j:
                up += ground[j] * (i-j)
                time += ground[j] * (i-j)
            else:
                down += ground[j] * (j-i)
                time += (ground[j] * (j-i))*2
    if down + b < up:
        continue
    if pre_time>time:
        pre_time = time
        hei = i
    elif pre_time==time:
        hei = max(i, hei)
print(pre_time, hei)