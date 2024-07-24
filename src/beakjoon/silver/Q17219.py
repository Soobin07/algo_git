map = dict()
str_ = input().split()
for i in range(int(str_[0])) :
    tmp = input().split()
    map[tmp[0]] = tmp[1]

for i in range(int(str_[1])) :
    print(map[input()])