X = input()
if X[0] == '0':
    if X[1] == 'x':
       num = int(X, 16)
    else:
        num = int(X, 8)
else:
    num = int(X)
print(num)
