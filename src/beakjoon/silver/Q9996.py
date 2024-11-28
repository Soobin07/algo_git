import re
n = int(input())
front, end = input().split("*")
pattern = re.compile(front+".*"+end+"+")

for i in range(n) :
	string = input()
	a = pattern.search(string)
	if a and a.group()==string :
		print("DA")
	else :
		print("NE")