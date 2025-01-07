# 20291 파일 정리
N = int(input())
dicts = {}
for n in range(N):
    tmp = input().split(".")
    if tmp[1] in dicts:
        dicts[tmp[1]] += 1
    else:
        dicts[tmp[1]] = 1

dicts = dict(sorted(dicts.items()))
for i in dicts.items():
    print(i[0]+" "+str(i[1]))