N = int(input())
cate = list(map(int, input().split()))
arr = list(map(int, input().split()))
M = int(input())
narr = list(map(int, input().split()))

queue = list()
for i in range(N):
    if cate[N - 1 - i] == 0:
        queue.append(arr[N - 1 - i])

for m in narr:
    queue.append(m)

print(*queue[0:M])