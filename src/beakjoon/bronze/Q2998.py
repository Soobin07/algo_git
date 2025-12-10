b = input().strip()

while len(b) % 3 != 0:
    b = '0' + b

answer = ''
for i in range(0, len(b), 3):
    answer += str(int(b[i:i+3], 2))  

print(answer)
