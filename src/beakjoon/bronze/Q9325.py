t = int(input())
for tc in range(t) :
    s = int(input())
    oc = int(input())
    for o in range(oc) :
        q, p = map(int, input().split())
        s += p*q
    print(s)