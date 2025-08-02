N = int(input())
Hs = list(map(int, input().split()))
cnt = 1
for i in range(1, N):
    if Hs[i] >= Hs[i-1]:
        cnt+=1
print(cnt)
