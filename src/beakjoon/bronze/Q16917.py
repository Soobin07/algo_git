A, B, C, X, Y = map(int, input().split())
ans = A * X + B * Y
tmp = min(X, Y)
ans = min(ans, (C*2*tmp + A*(X-tmp) + B*(Y-tmp)))
tmp = max(X, Y)
ans = min(ans, (C*2*tmp))
print(ans)
