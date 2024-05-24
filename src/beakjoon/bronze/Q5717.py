while(True) :
    string = input().split(" ")
    a = int(string[0])
    b = int(string[1])

    if a == b and a == 0 :
        break
    
    print(a + b)
