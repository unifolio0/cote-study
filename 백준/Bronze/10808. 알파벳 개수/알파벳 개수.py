import sys
input = sys.stdin.readline
mid = list(input().replace('\n', ''))
st = [0]*26
for i in mid:
    st[ord(i)-ord('a')] += 1
print(*st)