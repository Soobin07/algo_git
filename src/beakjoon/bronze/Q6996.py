tc = int(input())
for t in range(tc) :
    arrA = [0]*26
    arrB = [0]*26
    A, B = input().split()
    for c in A :
        arrA[ord(c)-ord('a')] += 1
    for c in B :
        arrB[ord(c)-ord('a')] += 1
    
    flag = False
    for i in range(26) :
        if arrA[i] != arrB[i] :
            flag = True
            break
    print(A+" & "+B+" are", end="")
    print(" NOT" if flag else "", end="")
    print(" anagrams.")