before = float(input())
while(True):
    now = float(input())
    if(now == float("999")):
        break
    print("{:.2f}".format(round((now-before),2)))
    before = now
