na, nb = map(int, input().split())
list_a = list(map(int, input().split()))
list_b = set(map(int, input().split()))

list_ans = [a for a in list_a if a not in list_b]

print(len(list_ans))
if len(list_ans) > 0:
    list_ans.sort()
    print(' '.join(map(str, list_ans)))