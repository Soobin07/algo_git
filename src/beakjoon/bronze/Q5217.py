tc = int(input())
for t in range(0, tc) : 
    n = int(input())
    a = 0
    b = 0
    flag = False
    cnt = 0
    pair = []
    for a in range(1, 13) :
        for b in range(a + 1, 13) :
            if a+b > n :
                flag = True
                break
            if a+b == n :
                cnt+= 1
                pair.append([a,b])
    
    str_ = "Pairs for "+str(n)+": "; 
    for i in pair :
        str_ += str(i[0])+" "+str(i[1])
        str_ += ", "
    if len(pair) > 0 :
        str_= str_.removesuffix(", ",)
    print(str_)
