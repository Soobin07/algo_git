N = int(input())
for i in range(0, N) :
    arr = input().split()
    min_ = 100
    sum_ = 0
    for j in range(0, 7) :
        if int(arr[j]) % 2 == 0 :
            min_ = min(min_, int(arr[j]))
            sum_ += int(arr[j])

    print(str(sum_)+" "+str(min_))