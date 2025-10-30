n = int(input())
teas = list(map(int, input().split()))

cnt = 0

for i in teas:
    if i == n:
        cnt += 1

print(cnt)
