package src.beakjoon.silver;
import java.util.*;

public class Q11123 {
    static int H, W;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            H = sc.nextInt();
            W = sc.nextInt();
            map = new char[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                map[i] = sc.next().toCharArray();
            }

            int count = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == '#' && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void bfs(int sy, int sx) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sy, sx});
        visited[sy][sx] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int ny = cur[0] + dy[dir];
                int nx = cur[1] + dx[dir];
                if (ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] != '#') continue;

                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }
    }
}
