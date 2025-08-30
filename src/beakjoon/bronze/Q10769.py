happy = 0
sad = 0

arr = input()

for i in range(len(arr) - 2):
    if arr[i:i+3] == ":-)":
        happy += 1
    elif arr[i:i+3] == ":-(":
        sad += 1

if happy == sad:
    if happy != 0:
        print("unsure")
    elif happy == 0:
        print("none")
elif happy > sad:
    print("happy")
elif happy < sad:
    print("sad")
