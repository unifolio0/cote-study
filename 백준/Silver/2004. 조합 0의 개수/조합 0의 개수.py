import sys
import math
input = sys.stdin.readline
n, m = map(int,input().split())
def comcount(num, cou):
    ans = 0
    while num!=0:
        ans += num//cou
        num//=cou
    return ans
print(min((comcount(n, 2)-comcount(m, 2)-comcount(n-m, 2)),(comcount(n, 5)-comcount(m, 5)-comcount(n-m, 5))))