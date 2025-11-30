C, K = map(int, input().split())
unit = 10 ** K

r = C % unit
if r * 2 < unit:
    print(C - r)
else:
    print(C + (unit - r))
