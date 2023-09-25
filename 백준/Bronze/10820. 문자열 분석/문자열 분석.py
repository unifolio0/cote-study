while True:
    try:
        i = list(input())
        st = [0]*4
        for j in i:
            if 'a'<=j<='z':
                st[0]+=1
            elif 'A'<=j<='Z':
                st[1]+=1
            elif '0'<=j<='9':
                st[2]+=1
            else:
                st[3]+=1
        print(*st)
    except EOFError:
        break