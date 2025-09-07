N = int(input())
# 10에는 3번 있다
# 100에는 10*3 + 3*10번 있다
# 1000애는 (10*3 + 3* 10)+3*100번 있다

sum_ = 0
for i in range(N+1) :
    for l in str(i) :
        if l == '3' or l == '6' or l == '9' :
            sum_ += 1
print(sum_)