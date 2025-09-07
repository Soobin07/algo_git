# 입력
birth_year, birth_month, birth_day = map(int, input().split())
curr_year, curr_month, curr_day = map(int, input().split())

# 만 나이 계산
if (curr_month, curr_day) < (birth_month, birth_day):
    man_age = curr_year - birth_year - 1
else:
    man_age = curr_year - birth_year

# 한국식 나이 계산
korean_age = curr_year - birth_year + 1

# 연 나이 계산
year_age = curr_year - birth_year

# 출력
print(man_age)
print(korean_age)
print(year_age)

