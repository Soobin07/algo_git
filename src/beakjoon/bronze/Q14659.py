N = int(input())
arr = list(map(int, input().split()))

h = 0
cnt = 0
max_cnt = 0
for i in range(0, len(arr)) :
    if h > arr[i] :
        cnt += 1
    else :
        h = arr[i]
        max_cnt = max(max_cnt, cnt)
        cnt = 0

max_cnt = max(max_cnt, cnt)

print(max_cnt)