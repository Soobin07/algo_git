import math

T = int(input())

for t in range(0, T):
    d = int(input())
    x = 0
    while x * x + x <= d:
        x += 1
    print(x - 1)
