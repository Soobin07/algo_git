import math

n = int(input())
for _ in range(n):
    b = int(input())
    result = math.comb(b + 9, 9)
    print(result)