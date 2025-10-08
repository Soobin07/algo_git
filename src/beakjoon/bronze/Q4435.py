T = int(input())

g_att = [1, 2, 3, 3, 4, 10]
s_att = [1, 2, 2, 2, 3, 5, 10]

for t in range(0, T):
    g_army = list(map(int, input().split()))
    s_army = list(map(int, input().split()))

    g_sum = 0
    for i in range(0, 6):
        g_sum += (g_att[i]*g_army[i])

    s_sum = 0
    for j in range(0, 7):
        s_sum += (s_att[j]*s_army[j])

    ans = "Good triumphs over Evil"
    if g_sum < s_sum:
        ans = "Evil eradicates all trace of Good"
    elif g_sum == s_sum:
        ans = "No victor on this battle field"
        
    print(f"Battle {t+1}: {ans}")
