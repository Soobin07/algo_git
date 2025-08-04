N, M = map(int, input().split())
list_ = []
for n in range(1, N*M+1):
    list_.append(str(n))
    if n % M == 0:
        list_.append('\n')
    else:
        list_.append(' ')
str_ = ''.join(list_)
print(str_)
