s = int(input())
sum = 0
cnt = 0
for i in range(1, 4294967295) :
    sum += i
    cnt += 1
    if(sum == s) :
        break
    elif(sum > s) :
        if(sum - s <= i) :
            cnt-=1
            break

print(cnt)
