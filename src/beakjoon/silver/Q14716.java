package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14716 {
    static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
    static int M, N;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visit = new boolean[M][N];

        // Read the map and initialize visit array
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int clusters = 0;

        // Loop through the grid and find unvisited 1's to start DFS
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    dfs(i, j);
                    clusters++; // Increase the cluster count
                }
            }
        }

        System.out.println(clusters);
    }

    public static void dfs(int r, int c) {
        visit[r][c] = true;

        for (int d = 0; d < 8; d++) { // 8 directions
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
                if (!visit[nr][nc] && map[nr][nc] == 1) {
                    dfs(nr, nc);
                }
            }
        }
    }
}