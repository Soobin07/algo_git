T = int(input())
for i in range(T):
    input()
    N, M = map(int, input().split())
    NS = list(map(int, input().split()))
    MS = list(map(int, input().split()))
    NS.sort(reverse=True)
    MS.sort(reverse=True)

    while NS and MS:
        if NS[-1] >= MS[-1]:
            MS.pop()
        else:
            NS.pop()

    if len(NS) > len(MS):
        print("S")
    elif len(NS) < len(MS):
        print("B")
    else :
        print("C")
