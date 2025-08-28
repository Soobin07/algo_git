import sys
input = sys.stdin.readline

N, K, L = map(int, input().split())
team_cnt = 0
member = []
for n in range(N):
    x1, x2, x3 = map(int, input().split())
    if x1 < L or x2 < L or x3 < L:
        continue
    if (x1 + x2 + x3) < K:
        continue
    
    team_cnt += 1
    member.extend([x1, x2, x3])

print(team_cnt)
print(*member)
