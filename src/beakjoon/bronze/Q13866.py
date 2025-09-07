skill = list(map(int, input().split()))
skill.sort()
first = skill[0]+skill[3]
second = skill[1]+skill[2]

print(abs(first - second))