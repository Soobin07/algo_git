T = int(input())
for t in range(T) :
    arr = list(map(int, input().split()))
    arr.sort()
    print(arr[7])