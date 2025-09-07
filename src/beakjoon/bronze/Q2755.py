from decimal import Decimal, getcontext

# 소수점 연산 정밀도 설정
getcontext().prec = 10

N = int(input())
d = {
    "A+": Decimal("4.3"), "A0": Decimal("4.0"), "A-": Decimal("3.7"),
    "B+": Decimal("3.3"), "B0": Decimal("3.0"), "B-": Decimal("2.7"),
    "C+": Decimal("2.3"), "C0": Decimal("2.0"), "C-": Decimal("1.7"),
    "D+": Decimal("1.3"), "D0": Decimal("1.0"), "D-": Decimal("0.7"),
    "F": Decimal("0.0")
}

class_cnt = Decimal("0")
grade_sum = Decimal("0")
for _ in range(N):
    n, c, g = input().split()
    class_cnt += Decimal(c)
    grade_sum += d[g] * Decimal(c)

# 소수점 둘째 자리 반올림 출력
print(f"{grade_sum / class_cnt:.2f}")
