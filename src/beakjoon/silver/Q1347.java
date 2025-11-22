package src.beakjoon.silver;
import java.io.*;
import java.util.*;

public class Q1347 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        char[][] map = new char[100][100];
        for (char[] row : map) Arrays.fill(row, '#');

        // 북, 동, 남, 서 (반시계 의미 유지)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int dir = 2; // 남쪽부터 시작

        int x = 50, y = 50;
        map[x][y] = '.';

        for (char c : s.toCharArray()) {
            if (c == 'F') {
                x += dx[dir];
                y += dy[dir];
                map[x][y] = '.';
            } else if (c == 'L') {
                dir = (dir + 3) % 4; // 왼쪽 회전
            } else if (c == 'R') {
                dir = (dir + 1) % 4; // 오른쪽 회전
            }
        }

        int minX = 100, minY = 100, maxX = 0, maxY = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == '.') {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
