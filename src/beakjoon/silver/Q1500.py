import sys
S, K = map(int, sys.stdin.readline().split())
q, r = divmod(S, K)
result = 1
for _ in range(K - r):
    result *= q
for _ in range(r):
    result *= (q + 1)
print(result)
