N, M = map(int, input().split())
result = str(N) * N  # N을 N번 반복
print(result[:M])    # 앞 M자리만 출력
