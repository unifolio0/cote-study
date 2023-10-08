import sys
input = sys.stdin.readline
k = int(input())
st = []
for i in range(k):
    n = int(input())
    if n != 0:
        st.append(n)
    else:
        st.pop()
print(sum(st))