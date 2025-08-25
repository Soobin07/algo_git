Money = int(input())
Price = list(map(int, input().split(' ')))

J_money = Money
J_stock = 0

for day in range(14):
    if Price[day] <= J_money:
        J_stock += J_money//Price[day]
        J_money %= Price[day]

J_money += J_stock * Price[13]

S_money = Money
S_stock = 0

for day in range(14-3):
    if Price[day] < Price[day+1] and Price[day+1] < Price[day+2] and Price[day+2] < Price[day+3]:
        S_money += S_stock * Price[day+3]
        S_stock = 0
    elif Price[day] > Price[day+1] and Price[day+1] > Price[day+2] and Price[day+2] > Price[day+3]:
        S_stock += S_money//Price[day+3]
        S_money %= Price[day+3]
        
S_money += S_stock * Price[13]

print('BNP' if J_money > S_money else 'SAMESAME' if J_money == S_money else 'TIMING')
