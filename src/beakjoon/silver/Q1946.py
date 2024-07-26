class Person :
    def __init__(self, s, m) :
        self.s = s
        self.m = m
TC = int(input())
for tc in range(TC) :
    arr = []
    N = int(input())
    for n in range(N) :
        s, m = map(int, input().split())
        arr.append(Person(s,m))
    sort = sorted(arr, key = lambda x : x.s)
    ans = 0
    min_m = N
    for i in range(N) :
        if sort[i].m <= min_m :
            ans += 1
            min_m = sort[i].m
    print(ans)