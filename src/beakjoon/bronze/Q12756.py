A_att, A_hp = map(int, input().split())
B_att, B_hp = map(int, input().split())

while(True):
    A_hp -= B_att
    B_hp -= A_att
    
    if A_hp <= 0 and B_hp <= 0:
        print("DRAW")
        break
    elif A_hp <= 0:
        print("PLAYER B")
        break
    elif B_hp <= 0:
        print("PLAYER A")
        break
