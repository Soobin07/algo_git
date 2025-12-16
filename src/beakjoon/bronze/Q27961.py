import math

N = int(input())

if N == 0:
    print(0)
else:
    print(math.ceil(math.log2(N)) + 1)
