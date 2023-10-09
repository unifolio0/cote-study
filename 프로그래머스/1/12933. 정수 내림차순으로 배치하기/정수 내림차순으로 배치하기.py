def solution(n):
    re = sorted(list(str(n)))
    re.reverse()
    re = ''.join(re)
    answer = int(re)
    return answer