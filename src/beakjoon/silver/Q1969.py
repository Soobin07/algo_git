# 입력 처리
N, M = map(int, input().split())
arr = [input() for _ in range(N)]

# 결과 변수
result_dna = ""
min_distance = 0

# 각 열에서 가장 많이 나타나는 문자 찾기
for col in range(M):
    freq = {"A": 0, "C": 0, "G": 0, "T": 0}
    
    # 열에 있는 문자 빈도수 계산
    for row in range(N):
        freq[arr[row][col]] += 1

    # 가장 많이 나타나는 문자 찾기 (동률일 경우 사전순 우선)
    max_count = max(freq.values())
    for char in "ACGT":
        if freq[char] == max_count:
            result_dna += char
            break

# Hamming Distance 계산
for row in range(N):
    for col in range(M):
        if arr[row][col] != result_dna[col]:
            min_distance += 1

# 결과 출력
print(result_dna)
print(min_distance)
