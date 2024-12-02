def start(i:int, j:int, numb:str) :
    if len(numb) == 6 :
        if numb not in s :
            s.append(numb)
        return
    dr = [0,0,1,-1]
    dc = [1,-1,0,0]
    for d in range(4):
        tr = i+dr[d]
        tc = j+dc[d]
        if 0 <= tr < 5 and 0 <= tc < 5 :
            start(tr, tc, numb+arr[tr][tc])
s = []
arr = [list(map(str, input().split())) for _ in range(5)]

for i in range(5) :
    for j in range(5) :
        start(i,j,str(arr[i][j]))

print(len(s))