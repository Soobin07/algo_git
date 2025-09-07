N = int(input())
up = 10
while (N//up) > 0:
    res = N%up
    if res * 2 >= up:
        N=N+up
    up=up*10
    N=N-res

print(N)