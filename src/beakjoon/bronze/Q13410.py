N, K = map(int, input().split())
max_ = 0
for i in range(1, K+1):
    str_ = list(str(i*N))
    str_.reverse()
    str_ = ''.join(str_)
    max_ = max(max_, int(str_))

print(max_)
