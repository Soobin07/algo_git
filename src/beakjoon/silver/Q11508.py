N = int(input())
arr = list()
for _ in range(N):
    arr.append(int(input()))

arr.sort()
arr.reverse()

cnt = 0
for i in range(0, N, 3):
    cnt += sum(arr[i:i+2])

print(cnt)