T = int(input())  # 테스트 케이스 수 입력

for _ in range(T):
    n = int(input())  # 박스 크기 입력

    if n == 1:
        print("#")
    else:
        # 첫째 줄
        print("#" * n)
        # 중간 줄
        for _ in range(n - 2):
            print("#" + "J" * (n - 2) + "#")
        # 마지막 줄
        print("#" * n)
    
    print()