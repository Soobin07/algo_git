package src.beakjoon.silver;
import java.io.*;
import java.util.*;

public class Q25418 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[k + 1];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{a, 0});
        visited[a] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int cnt = cur[1];

            if (x == k) {
                System.out.println(cnt);
                return;
            }

            // x + 1
            if (x + 1 <= k && !visited[x + 1]) {
                visited[x + 1] = true;
                q.add(new int[]{x + 1, cnt + 1});
            }

            // x * 2
            if (x * 2 <= k && !visited[x * 2]) {
                visited[x * 2] = true;
                q.add(new int[]{x * 2, cnt + 1});
            }
        }
    }
}
