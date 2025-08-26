prime = [True] * 100000
prime[0] = False
prime[1] = False

for i in range(2, 100000):
    if prime[i]:
        for j in range(i * 2, 100000, i):
            prime[j] = False
            
TC = int(input())
for tc in range(TC):
    N = int(input())
    for i in range(2, 100000):
        if i > N:
            break
        if prime[i] :
            cnt = 0
            while(N % i == 0):
                cnt+=1
                N = N//i
            if cnt > 0:
                print(str(i) + " " + str(cnt))
