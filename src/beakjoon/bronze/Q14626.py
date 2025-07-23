str_ = input()
sums_ = 0
index = -1
for i in range(0, 13):
    if str_[i] == '*':
        index = i
        continue
    else:
        if i % 2 == 0:
            sums_ = sums_ + int(str_[i])
        else:
            sums_ = sums_ + (int(str_[i]) * 3)

if sums_ % 10 == 0:
    print(0)
else:
    if index % 2 == 0:
        print(10 - (sums_ % 10))
    else:
        ans = 10 - (sums_ % 10)
        for i in range(0, 10):
            if ans == (i * 3) % 10:
                print(i)
                break
