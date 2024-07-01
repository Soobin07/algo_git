T = int(input())
for i in range(0, T) :
    N = int(input())
    arr = map(int, input().split())
    sum = 0
    for a in arr :
        sum += a
    print(sum)