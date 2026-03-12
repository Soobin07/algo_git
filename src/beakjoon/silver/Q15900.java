package src.beakjoon.silver;
import java.io.*;
import java.util.*;

public class Q15900 {

    static List<Integer>[] tree;
    static boolean[] visited;
    static int sum = 0;

    public static void dfs(int node, int depth) {
        visited[node] = true;
        boolean isLeaf = true;

        for (int next : tree[node]) {
            if (!visited[next]) {
                isLeaf = false;
                dfs(next, depth + 1);
            }
        }

        if (isLeaf) {
            sum += depth;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1, 0);

        if (sum % 2 == 1) System.out.println("Yes");
        else System.out.println("No");
    }
}
