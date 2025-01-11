N = int(input())
arr = list()
for _ in range(N):
    arr.append(int(input()))
arr.sort()
arr.reverse()

tips = 0
for i in range(N):
    tips += max(arr[i]-i, 0)
print(tips)