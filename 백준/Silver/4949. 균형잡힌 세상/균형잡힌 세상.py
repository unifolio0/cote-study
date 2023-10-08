import sys
input = sys.stdin.readline
while True:
    a1 = []
    text = input()
    if text=='.\n':
        break
    else:
        text = list(text)
        for i in text:
            if i == '(' or i == '[':
                a1.append(i)
            elif i == ')':
                if a1:
                    if a1[-1] == '(':
                        a1.pop()
                    else:
                        print('no')
                        break
                else:
                    print('no')
                    break
            elif i == ']':
                if a1:
                    if a1[-1] == '[':
                        a1.pop()
                    else:
                        print('no')
                        break
                else:
                    print('no')
                    break
        else:
            if a1:
                print('no')
            else:
                print('yes')