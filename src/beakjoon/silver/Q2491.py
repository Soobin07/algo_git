def solve():
    N = int(input().strip())
    arr = list(map(int, input().split()))
    
    # 수열 길이가 1이면, 결과는 당연히 1
    if N == 1:
        print(1)
        return
    
    inc_count = 1  # arr[i] >= arr[i-1]
    dec_count = 1  # arr[i] <= arr[i-1]
    max_length = 1
    
    for i in range(1, N):
        if arr[i] >= arr[i-1]:
            inc_count += 1
        else:
            inc_count = 1
        
        if arr[i] <= arr[i-1]:
            dec_count += 1
        else:
            dec_count = 1
        
        # 최대 길이 갱신
        max_length = max(max_length, inc_count, dec_count)
    
    print(max_length)

solve()
