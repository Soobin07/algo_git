N = int(input())
chan = []
kbs = [0, 0]
dist = [0, 1]
for n in range(0, N) :
    str_ = input()
    chan.append(str_)
    if "KBS1" == str_ :
        kbs[0] = n
    elif "KBS2" == str_ :
        kbs[1] = n

if kbs[0] > kbs[1] :
    kbs[1] +=1

tmp = ""
for i in range(0, 2) :
    for n in range(0, kbs[i]) :
        tmp+="1"
    for n in range (kbs[i], dist[i], -1) :
        ch_tmp = chan[n]
        chan[n] = chan[n-1]
        chan[n-1] = ch_tmp
        tmp+="4"

tmp = tmp.replace("141", "3")
print(tmp)
