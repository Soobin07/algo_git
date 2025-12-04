import sys
input = sys.stdin.readline

def is_pal(s):
    return s == s[::-1]

T = int(input())
for _ in range(T):
    k = int(input())
    arr = [input().rstrip() for _ in range(k)]

    ans = None
    for i in range(k):
        for j in range(k):
            if i == j:
                continue
            w = arr[i] + arr[j]
            if is_pal(w):
                ans = w
                break
        if ans is not None:
            break

    print(ans if ans is not None else 0)
