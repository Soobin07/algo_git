N = int(input())
ans = 100000
for n in range(N):
    a, b = map(int, input().split())
    if a <= b :
        ans = min(b, ans)

if ans == 100000 :
    print(-1)
else :
    print(ans)