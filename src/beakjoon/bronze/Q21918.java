package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Q21918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 전구 상태 배열 (1-based 인덱스)
        int[] bulbs = new int[N + 1];

        // 초기 상태 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bulbs[i] = Integer.parseInt(st.nextToken());
        }

        // 명령 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1:
                    // b번째 전구를 c 상태로 변경
                    bulbs[b] = c;
                    break;
                case 2:
                    // b~c 범위 전구 상태 반전
                    for (int idx = b; idx <= c; idx++) {
                        bulbs[idx] ^= 1; // 0->1, 1->0
                    }
                    break;
                case 3:
                    // b~c 범위 전구 끄기 (0)
                    for (int idx = b; idx <= c; idx++) {
                        bulbs[idx] = 0;
                    }
                    break;
                case 4:
                    // b~c 범위 전구 켜기 (1)
                    for (int idx = b; idx <= c; idx++) {
                        bulbs[idx] = 1;
                    }
                    break;
            }
        }

        // 최종 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(bulbs[i]).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}
