letter = {
    'A': "000000",
    'B': "001111",
    'C': "010011",
    'D': "011100",
    'E': "100110",
    'F': "101001",
    'G': "110101",
    'H': "111010"
}

n = int(input())
letters = input()

result = ""
for i in range(n):
    code = letters[i*6:(i+1)*6]
    found = False

    for k, v in letter.items():
        diff = sum(a != b for a, b in zip(code, v))
        if diff <= 1:
            result += k
            found = True
            break

    if not found:
        print(i + 1)
        exit()

print(result)
