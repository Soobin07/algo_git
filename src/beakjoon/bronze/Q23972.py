K, N = map(int, input().split())
if N == 1:
    print(-1)
else:
    ans = (N*K)//(N-1)
    if (N*K)%(N-1):
        ans += 1
    print(ans)
