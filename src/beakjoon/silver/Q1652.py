# 누울 자리를 찾아라
# N * N 맵
# 똑바로 연속해서 2칸 이상의 빈 칸이 존재하면 
# 그 곳에 몸을 양 옆으로 쭉 뻗으면서 누울 수 있다.
# => 그 줄 못쓴다 (가로, 세로 상관 X) => No!!! 그냥 X..X..X면 2개임
# <input>
# N ==> 1~100
# N*N (Map) , .X (X :짐, . : 빈 공간)
# <output>
# 가로로 누울 수 있는 자리 ^ 세로로 ~

N = int(input())
# python 에서 2차원배열 선언하는 방법
# arr = [[0 for j in range(cols)] for i in range(rows)] => [0,0,...] ...

map = [[0 for j in range(N)] for i in range(N)]
for i in range(0, N) :
    map[i] = str(input())

# 브루트포스로 풀어도 안되지는 않을듯? 
c = 0
r = 0
# python -> 스페이스 주의! 스페이스 하나로 오류 발생!
# python에서는 label이 좀 다르게 쓰이는듯?
# outer label; 을 사용 할 수 없다! 
# flag를 사용해서 반복문을 나가는 형식으로 만들어야 한다. 
# 아니면 리턴, 오류 발생을 사용할 수 있다.
# breakpoint -> 디버깅용

# 가로
for i in range(0,N) :
    cnt = 0
    for j in range(0,N) :
        if map[i][j] == '.' :
            cnt += 1
        else :
            if cnt >= 2 :
                c += 1
            cnt = 0
    if cnt >= 2 :
        c += 1

# 세로
for i in range(0,N) :
    cnt = 0
    for j in range(0,N) :
        if map[j][i] == '.' :
            cnt += 1
        else :
            if cnt >= 2 :
                r += 1
            cnt = 0
    if cnt >= 2 :
        r += 1

print(str(c)+" "+str(r))
