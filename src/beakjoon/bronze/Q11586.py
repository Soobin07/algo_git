N = int(input().strip())
arrs = [list(input().rstrip()) for _ in range(N)]
K = int(input().strip())

if K == 1:
    for i in range(N):
        print("".join(arrs[i]))
elif K == 2:
    for i in range(N):
        print("".join(arrs[i][::-1]))
else:
    for i in range(N-1, -1, -1):
        print("".join(arrs[i]))
