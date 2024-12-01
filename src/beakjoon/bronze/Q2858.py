R, B = map(int, input().split())
# R = 2h+2w
# h+w = R/2
size = R + B
i = 3
while True :
    if size % i == 0 :
        if (i-2)*(size//i-2) == B:
            print(max(i, size//i), min(i, size//i))
            break
    i+=1