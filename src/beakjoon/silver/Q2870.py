import re

N = int(input())
arr = []
# 모든 줄에서 숫자 추출
for _ in range(N):
    string = input()
    arr += re.findall(r'\d+', string)

# 숫자를 정수로 변환하여 앞의 0 제거
arr = list(map(int, arr))

# 오름차순 정렬
arr.sort()

# 결과 출력
for i in arr:
    print(i)
