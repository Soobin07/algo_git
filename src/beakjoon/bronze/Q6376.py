from math import factorial

print("n e")
print("- -----------")

e = 0.0
for n in range(10):
    e += 1 / factorial(n)

    if n == 0:
        print("0 1")
    elif n == 1:
        print("1 2")
    elif n == 2:
        print("2 2.5")
    else:
        print(f"{n} {e:.9f}")
