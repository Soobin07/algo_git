import sys
input = sys.stdin.readline

A, B = map(int, input().split())
K, X = map(int, input().split())

low = K - X
high = K + X

start = max(low, A)
end = min(high, B)

if start > end:
    print("IMPOSSIBLE")
else:
    print(end - start + 1)
