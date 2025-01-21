# 입력 처리
n = int(input())

# DP 배열 초기화
dp = [0] * (n + 1)
dp[0] = 1  # 초기 조건

# 점화식 계산
for i in range(1, n + 1):
    for j in range(i):
        dp[i] += dp[j] * dp[i - 1 - j]

# 결과 출력
print(dp[n])
