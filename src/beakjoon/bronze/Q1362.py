o, w = map(int, input().split())
comm = input()
snr = 1
isDead = False
while(True):
    if comm == "# 0":
        if isDead:
            print(f"{snr} RIP")
        elif (o/2) < w < (o*2):
            print(f"{snr} :-)")
        else:
            print(f"{snr} :-(")
            
        o, w = map(int, input().split())
        if o == 0 and w == 0:
            break
        comm = input()
        snr += 1
        isDead = False
        continue

    tmp = comm.split()
    c = tmp[0]
    n = int(tmp[1])

    if isDead == False:
        if c == "F":
            w += n
        elif c == "E":
            w -= n

        if w <= 0:
            isDead = True

    comm = input()
    
