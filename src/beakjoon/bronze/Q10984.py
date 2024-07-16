T = int(input())
for t in range(T) :
    N = int(input())
    sum = 0
    all_c = 0
    for n in range(N) :
        str_ = input().split(" ")
        C = int(str_[0])
        G = float(str_[1])
        sum += C*G
        all_c += C
    print(int(all_c), round(sum/all_c,1) , sep=" ")
