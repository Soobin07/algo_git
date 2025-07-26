S = input()
if len(S) <= 2:
    print('CE')
else:
    if S[0] == '\"' and S[len(S)-1] == '\"':
        print(S[1:len(S)-1])
    else:
        print('CE')
