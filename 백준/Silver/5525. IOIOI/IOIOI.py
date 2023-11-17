import sys
fastinput = sys.stdin.readline
N = int(fastinput())
M = int(fastinput())
S = list(input())
count = 0
i = 0
co = 0
while i < len(S)-2:
    if S[i:i+3] == list("IOI"):
        i += 2
        co += 1
        if co == N:
            count += 1
            co -= 1
    else:
        i += 1
        co = 0
print(count)