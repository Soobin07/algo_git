def is_yujinsu(N):
    L = len(N)
    for i in range(1, L):  # 나누는 위치 i
        left = N[:i]       # 왼쪽 부분
        right = N[i:]      # 오른쪽 부분
        
        # 왼쪽, 오른쪽 곱 계산
        left_product = 1
        for ch in left:
            left_product *= int(ch)
        
        right_product = 1
        for ch in right:
            right_product *= int(ch)
        
        # 곱이 같으면 YES 반환
        if left_product == right_product:
            return "YES"
    
    # 모든 경우를 확인해도 없으면 NO 반환
    return "NO"

# 입력
N = input().strip()
print(is_yujinsu(N))
