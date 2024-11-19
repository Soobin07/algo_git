N = int(input())
for i in range(1, N+1) :
    string = list(input().split())
    print("Case #"+str(i)+": ",end="")
    for j in range(len(string)) :
        print(string[len(string) - 1 - j], end=" ")
    print()