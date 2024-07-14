dr = [1, 1, -1, -1, 2, 2, -2, -2]
dc = [2, -2, 2, -2, 1, -1, 1, -1]

N = 6
visit = [[False for j in range(N)] for i in range(N)]

def can_move(o_r, o_c, n_r, n_c) :
    for i in range(8) :
        r = o_r + dr[i]
        c = o_c + dc[i]
        if r == n_r and c == n_c :
            return True
    return False

def isVisited(r, c) :
    if visit[r][c] != True :
        return True
    return False

def get_r(o_r) :
    return int(ord(o_r)-ord('A'))
def get_c(o_c) :
    return int(o_c) - 1

def move_all():
    for i in range(6) :
        for j in range(6) :
            if visit[i][j] == False :
                return False
    return True

start = input().rstrip()
first = start
printed = False
i = 0
for i in range(35) :
    next = input().rstrip()
    if (can_move(get_r(start[0]), get_c(start[1]), get_r(next[0]), get_c(next[1])) and isVisited(get_r(start[0]), get_c(start[1]))) == False :
        print("Invalid")
        printed = True
        break
    visit[get_r(start[0])][get_c(start[1])] = True
    start = next

if printed == False :
    next = first
    visit[get_r(start[0])][get_c(start[1])] = True
    if can_move(get_r(start[0]), get_c(start[1]), get_r(next[0]), get_c(next[1])) == False :
        print("Invalid")
    elif move_all() == False:
        print("Invalid")
    else :
        print("Valid")
