while(True):
    str_ = input().split()
    name = str_[0]
    age = int(str_[1])
    weight = int(str_[2])

    if(name == "#") :
        break

    if(age > 17 or weight >= 80) :
        print(name+" Senior")
    else :
        print(name+" Junior")
