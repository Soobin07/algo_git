str_ = input()
q = list()
for c in range(len(str_)):
    if len(q) == 0:
        q.append(str_[c])
    else:    
        if str_[c] == ")" and q[-1] == "(":
            del q[-1]
        else:
            q.append(str_[c])
            
print(len(q))
