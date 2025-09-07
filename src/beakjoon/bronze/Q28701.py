N = int(input())
s = 0
for i in range(1, N+1):
    s += i
print(s)
print(s*s)
s2 = 0
for j in range(1, N+1):
    s2 += (j*j*j)
print(s2)
