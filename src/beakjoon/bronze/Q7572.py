N = int(input())
index = (N - 1984) % 60
alp = "ABCDEFGHIJKL"
print(alp[index % 12] + str(index % 10))
