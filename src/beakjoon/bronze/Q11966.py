n = int(input())
if n <= 0:
    print(0)
else:
    cnt = bin(n).count('1')
    if cnt == 1:
        print(1)
    else:
        print(0)