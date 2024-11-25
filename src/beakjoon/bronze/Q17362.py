n = int(input())
n = n%8
if n > 5 :
    n = 10 - n
elif n == 0 :
    n = (10 - n)%8
print(n)