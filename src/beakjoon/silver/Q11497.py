T = int(input())
for t in range(T) :
    N = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    max_ = 0
    for i in range(2, N) :
        max_ = max(max_, abs(arr[i]-arr[i-2]))
    print(max_)