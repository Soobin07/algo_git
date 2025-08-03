P = list(map(int, input().split()))
x, y, r = map(int, input().split())

ans = -1
for i in range(0, len(P)):
    if P[i] == x:
        print(i+1)
        ans = i

if ans == -1:
    print(0)
