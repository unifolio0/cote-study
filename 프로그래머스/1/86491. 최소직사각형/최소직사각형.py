def solution(sizes):
    w = [max(i) for i in sizes]
    h = [min(i) for i in sizes]
    answer = max(w)*max(h)
    return answer