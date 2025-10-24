D, M = map(int, input().split())
days_in_month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

days_passed = sum(days_in_month[:M-1]) + (D-1)

weekdays = ["Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"]
print(weekdays[days_passed % 7])
