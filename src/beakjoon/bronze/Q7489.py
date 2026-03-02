import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    n = int(input())
    result = 1
    count2 = 0
    count5 = 0

    for i in range(2, n + 1):
        x = i

        while x % 2 == 0:
            count2 += 1
            x //= 2

        while x % 5 == 0:
            count5 += 1
            x //= 5

        result *= x
        result %= 10**7  

    for _ in range(count2 - count5):
        result *= 2
        result %= 10**7

    print(result % 10)
