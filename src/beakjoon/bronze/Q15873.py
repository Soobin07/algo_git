str_ = input()

A = 0
B = 0
if(len(str_) >= 3):
    if str_[1] == '0':
        A = int(str_[0:2])
        B = int(str_[2:])
    else:
        A = int(str_[0])
        B = int(str_[1:])
else:
    A = int(str_[0])
    B = int(str_[1])
    
print(A+B)