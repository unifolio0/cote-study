def solution(s):
    ans = True
    st = []
    for i in s:
        if i == '(':
            st.append(i)
        else:
            if st:
                st.pop()
            else:
                ans = False
                break
    else:
        if st:
            ans = False
        else:
            ans = True
    return ans