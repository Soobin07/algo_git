import sys

input = sys.stdin.readline

Q = int(input().strip())
out_lines = []
for _ in range(Q):
    x = int(input().strip())
    out_lines.append('1' if x > 0 and (x & (x - 1)) == 0 else '0')

print('\n'.join(out_lines))