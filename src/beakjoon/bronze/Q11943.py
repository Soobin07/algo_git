A1, O1 = map(int, input().split())
A2, O2 = map(int, input().split())

min_ = min(A1+O2, O1+A2)
print(min_)