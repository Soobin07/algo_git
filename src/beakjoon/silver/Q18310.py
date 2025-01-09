# 입력 처리
n = int(input())
houses = list(map(int, input().split()))

# 집의 위치 정렬
houses.sort()

ans = houses[(n - 1) // 2] 
print(ans)