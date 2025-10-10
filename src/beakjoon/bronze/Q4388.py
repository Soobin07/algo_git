while True:
    a, b = input().split()
    if a == b == "0":
        break
    else:
        cnt = 0
        plus = 0
        min_len = min(len(a), len(b))
        for i in range(min_len):
            nums = int(a[-1-i]) + int(b[-1-i]) + plus
            if nums >= 10:
                plus = nums // 10
                cnt += 1
            else:
                plus = 0

        # 남은 자리들이 있으면 한 자리씩 더 검사해서 캐리 전파를 계속 처리
        if len(a) != len(b):
            longer = a if len(a) > len(b) else b
            for j in range(min_len, len(longer)):
                nums = int(longer[-1-j]) + plus
                if nums >= 10:
                    plus = nums // 10
                    cnt += 1
                else:
                    plus = 0
                    break

        print(cnt)
