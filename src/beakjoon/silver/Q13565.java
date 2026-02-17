package src.beakjoon.silver;
import java.io.*;
import java.util.*;

public class Q13565 {

    static int M, N;
    static int[][] map;
    static boolean[][] visited;
    static boolean success = false;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void dfs(int x, int y) {
        if (x == M - 1) {  
            success = true;
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int j = 0; j < N; j++) {
            if (map[0][j] == 0 && !visited[0][j]) {
                dfs(0, j);
            }
        }

        if (success) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
