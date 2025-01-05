n = int(input())
arr = list(map(int, input().split()))
arr.sort()
arr.reverse()

ans = 0

for i in range(n):
    ans = max(ans, arr[i]+(i+1))

print(ans+1)