count = dict()
count["INFP"] = 0
count["ENFP"] = 0
count["ISFP"] = 0
count["ESFP"] = 0
count["INTP"] = 0
count["ENTP"] = 0
count["ISTP"] = 0
count["ESTP"] = 0
count["INFJ"] = 0
count["ENFJ"] = 0
count["ISFJ"] = 0
count["ESFJ"] = 0
count["INTJ"] = 0
count["ENTJ"] = 0
count["ISTJ"] = 0
count["ESTJ"] = 0

jiho = input()
N = int(input())

for i in range(N):
    count[input()] += 1

print(count[jiho])
