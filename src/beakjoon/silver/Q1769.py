def question(x:str, cnt:int):
    cnt += 1
    sum_ = 0
    for s in x:
        sum_ += int(s)
    
    if sum_ >= 10:
        question(str(sum_), cnt)
    else:
        print(cnt)
        if sum_ == 3 or sum_ == 6 or sum_ == 9:
            print("YES")
        else:
            print("NO")
X = input()
if int(X) >= 10:
    question(X, 0)
else:
    print(0)
    if int(X) == 3 or int(X) == 6 or int(X) == 9:
        print("YES")
    else:
        print("NO")