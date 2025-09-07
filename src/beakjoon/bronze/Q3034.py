N, W, H = map(int, input().split())
max_ = (W**2 + H**2) **0.5
for n in range(N) :
    l = int(input())
    print("DA" if l <= max_ else "NE")
    