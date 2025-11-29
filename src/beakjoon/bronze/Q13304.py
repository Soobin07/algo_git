N, K = map(int, input().split())

# 그룹 인원 수
g12 = 0          # 1~2학년 (성별 구분 없음)
g34 = [0, 0]     # 3~4학년 남/여
g56 = [0, 0]     # 5~6학년 남/여

for _ in range(N):
    S, Y = map(int, input().split())   # 성별 S, 학년 Y

    if Y <= 2:         # 1~2학년 → 성별 구분 없음
        g12 += 1

    elif Y <= 4:       # 3~4학년 → 남/여 구분
        g34[S] += 1

    else:              # 5~6학년 → 남/여 구분
        g56[S] += 1

# 방 수 계산 함수
def rooms(x):
    return (x + K - 1) // K

# 최종 방 개수
ans = rooms(g12) + rooms(g34[0]) + rooms(g34[1]) + rooms(g56[0]) + rooms(g56[1])
print(ans)
