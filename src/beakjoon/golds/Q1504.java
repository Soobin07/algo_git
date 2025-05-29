package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

public class Q1504 {
    static final int INF = 1_000_000_000;

    static class Node {
        int to, cost;
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Node>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] distFromStart = dijkstra(1, adj, N);
        int[] distFromV1    = dijkstra(v1, adj, N);
        int[] distFromV2    = dijkstra(v2, adj, N);

        // 1 → v1 → v2 → N 과 1 → v2 → v1 → N 두 경로 중 최소
        long path1 = (long) distFromStart[v1] + distFromV1[v2] + distFromV2[N];
        long path2 = (long) distFromStart[v2] + distFromV2[v1] + distFromV1[N];
        long answer = Math.min(path1, path2);

        // 불가능 구간이 있으면 -1
        System.out.println(answer >= INF ? -1 : answer);
    }

    static int[] dijkstra(int start, List<Node>[] adj, int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.to]) continue;

            for (Node nxt : adj[cur.to]) {
                int nd = cur.cost + nxt.cost;
                if (nd < dist[nxt.to]) {
                    dist[nxt.to] = nd;
                    pq.add(new Node(nxt.to, nd));
                }
            }
        }

        return dist;
    }
}
