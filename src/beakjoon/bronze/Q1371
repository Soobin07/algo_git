import sys
input = sys.stdin.read

string = input().replace("\n","").replace(" ","")
c_arr = [0] * 26
for i in string:
    c_arr[ord(i)-ord('a')] += 1
    
maxx = max(c_arr)
ans = []
for i in range(len(c_arr)):
    if c_arr[i] == maxx:
        ans.append(chr(i+97))
        
ans.sort()
print(*ans,sep="")
