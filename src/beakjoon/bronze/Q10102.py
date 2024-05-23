v = int(input())
s = input()

a = 0
b = 0
for i in range(len(s)) :
    if s[i] == 'A' :
        a += 1
    else :
        b += 1

if a > b :
    print("A")
elif a < b :
    print("B")
else :
    print("Tie")
