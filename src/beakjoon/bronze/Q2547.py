t = int(input())
for i in range(0, t):
    input()
    n = int(input())
    sum = 0
    for k in range(0, n):
        sum += int(input())

    if sum % n == 0:
        print("YES")
    else:
        print("NO")