T = int(input())
for i in range(T):
    HP, MP, AT, DF, H, M, A, D = map(int, input().split())

    HP = max(HP + H, 1)
    MP = max(MP + M, 1)
    AT = max(AT + A, 0)
    DF = DF + D
    ANS = HP + 5 * MP + 2 * AT + 2 * DF
    print(ANS)
