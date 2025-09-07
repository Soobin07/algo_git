n = int(input())
for i in range(n) :
    le = sorted(map(int, input().split()))
    print(f"Scenario #{i+1}:")
    if le[0]**2 + le[1]**2 == le[2]**2 :
        print("yes\n")
    else :
        print("no\n")