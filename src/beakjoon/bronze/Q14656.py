N = int(input())
list_ = list(map(int, input().split()))

cnt = 0
for i in range(1, N+1):
    if list_[i-1] != i:
        cnt += 1

print(cnt)
