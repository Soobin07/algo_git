n = int(input())
arr = [0]*(n)
if n <= 2:
    print(1)
else:
    arr[0] = arr[1] = arr[2] = 1
    for i in range(3, n):
        arr[i] = arr[i-1] + arr[i-3]
    
    print(arr[n-1])