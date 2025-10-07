def sum_(n, jari):
    s = 0
    while n > 0:
        s += n % jari
        n //= jari
    return s
    
for i in range(1000, 10000):
    s10 = sum_(i, 10)
    s12 = sum_(i, 12)
    s16 = sum_(i, 16)

    if s10 == s12 == s16:
        print(i)
