n = int(input())
q = [0, 0, 0, 0, 0]
for i in range(0,n):
    string = input().split(" ")
    x = int(string[0])
    y = int(string[1])
    if x == 0 or y == 0 :
        q[0] += 1
    elif x > 0 :
        if y > 0 :
            q[1] += 1
        else :
            q[4] += 1
    else :
        if y > 0 :
            q[2] += 1
        else :
            q[3] += 1

for i in range(1, 5) :
    print("Q"+str(i)+": "+str(q[i]))
print("AXIS: "+str(q[0]))
