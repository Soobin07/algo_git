package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17363 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        java.util.Map<Character, Character> map = new java.util.HashMap<>();
        map.put('.', '.');
        map.put('O', 'O');
        map.put('-', '|');
        map.put('|', '-');
        map.put('/', '\\');
        map.put('\\', '/');
        map.put('^', '<');
        map.put('<', 'v');
        map.put('v', '>');
        map.put('>', '^');

        StringBuilder sb = new StringBuilder();
        for (int col = M - 1; col >= 0; col--) {
            for (int row = 0; row < N; row++) {
                sb.append(map.get(arr[row][col]));
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
