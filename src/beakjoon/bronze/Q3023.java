package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q3023 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        char[][] result = new char[2 * R][2 * C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result[i][j] = arr[i][j];

                result[i][2 * C - 1 - j] = arr[i][j];
            }
        }
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < 2 * C; j++) {
                result[2 * R - 1 - i][j] = result[i][j];
            }
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()) - 1;
        int B = Integer.parseInt(st.nextToken()) - 1;

        if (result[A][B] == '.') {
            result[A][B] = '#';
        } else {
            result[A][B] = '.';
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2 * R; i++) {
            for (int j = 0; j < 2 * C; j++) {
                sb.append(result[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
