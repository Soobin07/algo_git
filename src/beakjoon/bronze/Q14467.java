package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q14467 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] pos = new int[11]; // 소 번호 1~10
        Arrays.fill(pos, -1);

        int count = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());

            // 처음 본 소
            if (pos[cow] == -1) {
                pos[cow] = location;
            } else {
                // 위치가 바뀐 경우
                if (pos[cow] != location) {
                    count++;
                    pos[cow] = location;
                }
            }
        }

        System.out.println(count);
    }
}
