cnt = 0
while True :
    n0 = int(input())
    cnt += 1
    if n0 == 0 :
        break
    isOdd = True
    n1 = 3 * n0
    n2 = 0
    if n1 % 2 == 0 :
        n2 = n1/2
        isOdd = False
    else :
        n2 = (n1+1)/2

    n3 = 3 * n2
    n4 = n3/9

    ans = str(cnt) + ". "
    if isOdd :
        ans +="odd "
    else :
        ans += "even "
    ans += str(int(n4))
    print(ans)
