N = int(input())
a, b, c = map(int, input().split())
happy = 0

if N > a:
    happy += a
else:
    happy += N
if N > b:
    happy += b
else:
    happy += N
if N > c:
    happy += c
else:
    happy += N
print(happy)
