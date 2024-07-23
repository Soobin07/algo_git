str_ = input()
arr = []
for i in range(0, len(str_)) :
    arr.append(str_[i:])

arr.sort()

for s in arr :
    print(s)