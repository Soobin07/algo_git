a, d, k = map(int, input().split())
cnt = 1
flag = True

if d != 0 and (k - a) % d == 0 and (k - a) // d >= 0:
    cnt = (k - a) // d + 1
    flag = False

if flag == False:
    print(cnt)
else:
    print("X")
