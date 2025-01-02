from collections import deque

# 입력 받기
R, C = map(int, input().split())
grid = [list(input()) for _ in range(R)]

# 방향 벡터 (상, 하, 좌, 우)
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

# 방문 여부
visited = [[False] * C for _ in range(R)]

# 결과 변수
total_sheep = 0
total_wolf = 0

# BFS 함수
def bfs(x, y):
    queue = deque([(x, y)])
    visited[x][y] = True
    
    sheep = 0
    wolf = 0

    while queue:
        cx, cy = queue.popleft()

        # 현재 위치 확인
        if grid[cx][cy] == 'o':
            sheep += 1
        elif grid[cx][cy] == 'v':
            wolf += 1

        # 인접한 노드 탐색
        for dx, dy in directions:
            nx, ny = cx + dx, cy + dy

            # 범위 내, 방문하지 않았으며 울타리가 아닌 경우
            if 0 <= nx < R and 0 <= ny < C and not visited[nx][ny] and grid[nx][ny] != '#':
                visited[nx][ny] = True
                queue.append((nx, ny))
    
    # 양과 늑대 수 비교
    if sheep > wolf:
        return sheep, 0  # 양이 살아남음
    else:
        return 0, wolf  # 늑대가 살아남음

# 전체 탐색
for i in range(R):
    for j in range(C):
        if not visited[i][j] and grid[i][j] != '#':
            sheep, wolf = bfs(i, j)
            total_sheep += sheep
            total_wolf += wolf

# 결과 출력
print(total_sheep, total_wolf)
