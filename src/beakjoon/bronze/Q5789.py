N = int(input())
for n in range(0, N):
    str_ = input()
    lens = int(len(str_)/2)
    if str_[(lens-1)] == str_[lens]:
        print("Do-it")
    else:
        print("Do-it-Not")
