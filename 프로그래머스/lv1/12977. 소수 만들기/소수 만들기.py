def solution(nums):
    answer = 0
    n = 50001
    prime = [True]*n
    for i in range(2, int(n**0.5)+1):
        if prime[i] == True:
            for j in range(i+i, n, i):
                prime[j] = False
    for i in range(len(nums)-2):
        for j in range(i+1, len(nums)-1):
            for k in range(j+1, len(nums)):
                if prime[nums[i]+nums[j]+nums[k]] == True:
                    answer+=1
    return answer