T = int(input())
for t in range(T) :
    n = int(input())
    arr = [0]*(n+1)
    for i in range(1, n+1) :
        for j in range(i, n+1, i) :
            arr[j]+= 1
    
    cnt = 0
    for i in range(1, n+1) :
        if arr[i]%2 != 0 :
            cnt+=1
    
    print(cnt)