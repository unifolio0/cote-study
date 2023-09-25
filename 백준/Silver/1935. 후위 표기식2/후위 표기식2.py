import sys
from collections import Counter
input = sys.stdin.readline
n = int(input())
c = list(input().replace("\n", ""))
st = []
num = []
for i in range(n):
    num.append(int(input()))
for i in c:
    if 'A'<=i<='Z':
        st.append(num[ord(i)-ord('A')])
    else:
        a = st.pop()
        b = st.pop()
        if i == '+':
            st.append(b+a)
        if i == '-':
            st.append(b-a)
        if i == '*':
            st.append(b*a)
        if i == '/':
            st.append(b/a)
print("{0:.2f}".format(st[0]))