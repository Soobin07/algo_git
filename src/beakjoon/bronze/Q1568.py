n = int(input())

cnt = 0
i = 1

while n > 0:
    if i > n:
        i = 1
    n -= i
    i += 1
    cnt += 1

print(cnt)