import sys
input = sys.stdin.readline
a = list(input().replace('\n', ''))
st = []
while a:
    st.append(''.join(a))
    a.pop(0)
st.sort()
for i in st:
    print(i)