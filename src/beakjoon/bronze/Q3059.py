T = int(input())
for _ in range(T):
    arr = [0]*26
    str_ = input()
    for i in str_:
        arr[ord(i)-65] += 1
    sum_ = 0
    for i in range(26):
        if arr[i] == 0 :
            sum_ += (i + 65)
    print(sum_)