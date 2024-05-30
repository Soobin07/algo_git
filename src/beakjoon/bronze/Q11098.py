## 첼시를 도와줘!
n = int(input())
for t in range(0, n) :
    p = int(input())
    c = int(0)
    name = ""
    for i in range(0,p) :
        str_ = input().split(" ")
        if int(c) < int(str_[0]) :
            c = int(str_[0])
            name = str_[1]
    print(name)
