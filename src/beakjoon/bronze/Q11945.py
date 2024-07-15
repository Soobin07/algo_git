N,M = map(int, input().split())

for i in range(0, N) :
    arr = list(input().rstrip())
    arr.reverse()
    for j in range(0, M) :
        print(arr[j],end="")
    print()