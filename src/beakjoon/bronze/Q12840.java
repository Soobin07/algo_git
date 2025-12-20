package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12840 {
    static final int DAY = 24 * 60 * 60; // 86400초

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기 시간 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int totalSeconds = h * 3600 + m * 60 + s;

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());

            if (T == 1) { // 앞으로
                int c = Integer.parseInt(st.nextToken());
                totalSeconds = (totalSeconds + c) % DAY;
            } 
            else if (T == 2) { // 뒤로
                int c = Integer.parseInt(st.nextToken());
                totalSeconds = (totalSeconds - c) % DAY;
                if (totalSeconds < 0) totalSeconds += DAY;
            } 
            else { // 출력
                int nh = totalSeconds / 3600;
                int nm = (totalSeconds % 3600) / 60;
                int ns = totalSeconds % 60;
                sb.append(nh).append(" ").append(nm).append(" ").append(ns).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
