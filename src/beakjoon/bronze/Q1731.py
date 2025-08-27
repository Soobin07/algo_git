N = int(input())
cha = False
cir = 0

arr = list()
for i in range(N):
    arr.append(int(input()))

if (arr[1]-arr[0] == arr[2]-arr[1]):
    cha = True
    cir = arr[1]-arr[0]
else:
    cir = arr[1]//arr[0]

if cha:
    print(arr[N-1]+cir)
else:
    print(arr[N-1]*cir)
