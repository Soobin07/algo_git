n = int(input())
arr = list(map(int, input().split()))

total = sum(arr)
answer = 0

for x in arr:
    total -= x
    answer += x * total

print(answer)
