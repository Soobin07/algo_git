arr = list(input())
for i in range(0, len(arr)) :
    if arr[i] >= 'A' and arr[i] <= 'C' :
        arr[i] = chr(ord(arr[i]) - ord('A') + ord('X'))
    else :
        arr[i] = chr(ord(arr[i]) - 3)

for i in arr :
    print(i, end="")