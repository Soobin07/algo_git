# 입력 처리
n = int(input())
x = list(map(int, input().split()))

# 오름차순 정렬
x.sort()

# 거리 합 계산
total_distance = 0
for i in range(n):
    total_distance += x[i] * (2 * i - n + 1)

# 결과 출력
print(total_distance * 2)
