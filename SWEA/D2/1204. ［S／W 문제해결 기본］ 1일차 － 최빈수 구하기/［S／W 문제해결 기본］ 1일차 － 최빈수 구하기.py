T = int(input())
for t in range(T):
    i = int(input())
    nums = list(map(int, input().split()))
    re = list(set(nums))
    res = []
    for j in range(len(re)):
        res.append(nums.count(re[j]))
    print("#{} {}".format(i, re[res.index(max(res))]))