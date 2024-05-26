T = int(input())
for t in range(0, T) :
    N = int(input())
    ans = ""
    max_mount = 0
    for n in range(0, N) :
        tmp = input().split(" ")
        if int(tmp[1]) > max_mount :
            max_mount = int(tmp[1])
            ans = tmp[0]
    print(ans)
