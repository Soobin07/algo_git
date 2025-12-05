T = int(input())
for _ in range(T):
    cmds = input().strip()
    x = y = 0
    dirs = [(0,1), (1,0), (0,-1), (-1,0)]
    dir_idx = 0  

    min_x = max_x = 0
    min_y = max_y = 0

    for c in cmds:
        if c == 'F':
            dx, dy = dirs[dir_idx]
            x += dx; y += dy
        elif c == 'B':
            dx, dy = dirs[dir_idx]
            x -= dx; y -= dy
        elif c == 'L':
            dir_idx = (dir_idx + 3) % 4
        elif c == 'R':
            dir_idx = (dir_idx + 1) % 4

        min_x = min(min_x, x)
        max_x = max(max_x, x)
        min_y = min(min_y, y)
        max_y = max(max_y, y)

    area = (max_x - min_x) * (max_y - min_y)
    print(area)
