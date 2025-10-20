n = int(input())
m = int(input())

cnt = m
flag = False
for _ in range(0, n):
    i, o = map(int, input().split())
    m += (i-o)
    cnt = max(cnt, m)

    if(m < 0):
        print(0)
        flag = True
        break

if(flag == False):
    print(cnt)
