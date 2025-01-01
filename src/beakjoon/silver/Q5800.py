K = int(input()) # 반의 수
for i in range(1, K+1):
    arr = [*map(int,input().split())]
    N = arr[0]
    arr.remove(N)
    arr.sort()
    print(f"Class {i}")
    gap = 0
    for n in range(1, N):
        gap = max(gap, arr[n] - arr[n-1])
    print(f"Max {arr[len(arr)-1]}, Min {arr[0]}, Largest gap {gap}")