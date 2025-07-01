N = int(input())
DP = [FALSE] * (N + 1)

if N >= 1:
	DP[1] = False
if N >= 2:
	DP[2] = True
if N >= 3:
	DP[1] = False
if N >= 4:
	DP[2] = True
	
for i in range(5, N + 1):
	if not DP[i - 1] or not DP[i - 3] or not DP[i - 4]:
		DP[i] = True
	else:
		DP[i] = False
		
print("SK" if DP[N] else "CY")