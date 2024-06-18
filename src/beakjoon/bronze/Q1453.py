N = int(input())
arr = [0]*101

guest = input().split(' ')
no = 0
for g in guest :
    if(arr[int(g)] == 0) :
        arr[int(g)] = 1
    else :
        no+=1

print(no)
