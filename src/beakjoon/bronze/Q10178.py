tc = int(input())
for _ in range(tc):
    c, v = map(int, input().split())
    print(f"You get {c//v} piece(s) and your dad gets {c%v} piece(s).")