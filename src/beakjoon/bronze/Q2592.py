map = dict()
avg = 0
max = 0
max_cnt = 0
for i in range(0,10) :
    num = int(input())
    if num in map :
        map[num] = map[num]+1
    else :
        map[num] = 1
    avg += num
    if map[num] > max_cnt :
        max = num
        max_cnt = map[num]

print(int(avg/10))
print(max)