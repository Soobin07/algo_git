import re
S = input()
S = re.sub(r'[0-9]', '', S)
K = input()
print(1 if K in S else 0)
