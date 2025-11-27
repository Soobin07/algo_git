K, L = map(str, input().split())
L = int(L)

# --- 에라토스테네스의 체로 L 미만 소수 구하기 ---
is_prime = [True] * L
is_prime[0] = is_prime[1] = False

p = 2
while p * p < L:
    if is_prime[p]:
        for i in range(p*p, L, p):
            is_prime[i] = False
    p += 1

primes = [i for i in range(2, L) if is_prime[i]]

# --- K % p 계산 함수 ---
def mod_str(K, p):
    r = 0
    for ch in K:
        r = (r * 10 + (ord(ch) - 48)) % p
    return r

# --- 소수에 대해서만 검사 ---
for p in primes:
    if mod_str(K, p) == 0:
        print("BAD", p)
        break
else:
    print("GOOD")
