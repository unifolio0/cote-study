import sys
input = sys.stdin.readline
n = int(input())
step = [0]*301
for i in range(n):
    step[i+1] = int(input())
score = [0]*301
score[1] = step[1]
score[2] = step[1]+step[2]
score[3] = max(step[3]+step[1], step[3]+step[2])
for i in range(4, n+1):
    score[i] = max(score[i-2], score[i-3]+step[i-1])+step[i]
print(score[n])