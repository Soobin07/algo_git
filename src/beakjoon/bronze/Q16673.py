cnt = 0
C, K, P = map(int, input().split())
for n in range(1, C+1):
    cnt += (K*n + P*n*n)

print(cnt)
