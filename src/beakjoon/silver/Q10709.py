# 입력 처리
R, C = map(int, input().split())
sky = [input() for _ in range(R)]

# 결과 저장
result = []

for row in sky:
    # 각 행에서 구름의 도달 시간 계산
    time = [-1] * C
    last_cloud = -1  # 구름의 마지막 위치
    for i in range(C):
        if row[i] == 'c':
            last_cloud = i
            time[i] = 0
        elif last_cloud != -1:
            time[i] = i - last_cloud
    result.append(time)

# 결과 출력
for row in result:
    print(" ".join(map(str, row)))