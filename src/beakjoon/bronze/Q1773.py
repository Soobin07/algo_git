N, C = map(int, input().split())
time = set()
for n in range(N) :
    intv = int(input())
    for t in range(intv, C+1, intv):
        time.add(t)

print(len(time))