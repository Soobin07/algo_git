word = input()
before = ''
cnt = 1
for w in range(0, len(word)):
    tmp = 0
    if word[w] == 'c':
        tmp = 26
        if before == 'c':
            tmp -= 1
    elif word[w] == 'd':
        tmp = 10
        if before == 'd':
            tmp -= 1
    cnt *= tmp
    before = word[w]

print(cnt)
