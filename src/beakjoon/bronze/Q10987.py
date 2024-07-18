str_ = input()
cnts = [0]*26

for i in str_ :
    cnts[ord(i) - int(97)] += 1

print(cnts[0]+cnts[8]+cnts[4]+cnts[14]+cnts[20])