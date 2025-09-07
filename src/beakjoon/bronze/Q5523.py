import sys 
N = int(sys.stdin.readline())
A_win = 0
B_win = 0
for i in range(N):
    A, B = map(int, sys.stdin.readline().split())
    if A > B :
        A_win = A_win+1
    elif A < B :
        B_win = B_win+1

print(str(A_win)+" "+str(B_win))