N = int(input())
dp = [False] * (N + 1)

dp[1] = True 
if N >= 2:
    dp[2] = False  
if N >= 3:
    dp[3] = True 
if N >= 4:
    dp[4] = True 

for i in range(5, N + 1):
    dp[i] = not dp[i - 1] or not dp[i - 3] or not dp[i - 4]

print("SK" if dp[N] else "CY")