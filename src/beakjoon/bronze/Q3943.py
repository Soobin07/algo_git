tc = int(input())

for i in range(tc) :
    n = int(input())
    max_ = n
    
    while n != 1:
        if n % 2 == 0:
            n = n / 2
        else:
            n = n * 3 + 1
            
        max_ = max(max_, n)
    
    print(str(int(max_)))
    
