def solution(n):
    answer = str(n)
    answer = list(answer)
    sum = 0
    for i in answer:
        sum+=int(i)
    return sum