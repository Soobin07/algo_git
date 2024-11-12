score = input().split(" ")

for i in range(len(score)) :
    score[i] = int(score[i])
school = ["Soongsil", "Korea", "Hanyang"]

if score[0]+score[1]+score[2] >= 100 : 
    print("OK")
else :
    print_s = ""
    min_ = min(score[0], min(score[1], score[2]))
    for i in range(len(score)) :
        if(min_ == score[i]) :
            print_s = school[i]
    print(print_s)