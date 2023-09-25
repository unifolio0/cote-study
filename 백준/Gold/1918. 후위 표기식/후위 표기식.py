import sys
input = sys.stdin.readline
mid = list(input().replace('\n', ''))
st = []
re = ''
for i in mid:
    if i.isalpha():
        re += i
    elif i == '(':
        st.append(i)
    elif i == '*' or i == '/':
        while st and (st[-1] == '*' or st[-1] == '/'):
            re += st.pop()
        st.append(i)
    elif i == '+' or i == '-':
        while st and st[-1] != '(':
            re += st.pop()
        st.append(i)
    elif i == ')':
        while st and st[-1] != '(':
            re += st.pop()
        st.pop()
while st:
    re += st.pop()

print(re)