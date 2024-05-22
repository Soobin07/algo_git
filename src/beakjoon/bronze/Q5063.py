N = int(input())
for i in range(N) : 
    # r : 광고x e: 광고 수익, c: 광고 비용
    rec = input().split(" ")
    r = int(rec[0])
    e = int(rec[1])
    c = int(rec[2])
    if  r > (e-c): 
        print("do not advertise")
    elif r == (e-c) :
        print("does not matter")
    else :
        print("advertise")
