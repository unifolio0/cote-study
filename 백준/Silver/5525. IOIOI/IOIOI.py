import sys
fastinput = sys.stdin.readline
N = int(fastinput())
M = int(fastinput())
S = list(input())
str = "I"
for i in range(N):
    str += "OI"
count = 0
for i in range(len(S)-(N*2)):
    if S[i:i+(N*2+1)] == list(str):
        count += 1
print(count)