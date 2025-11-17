package src.beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Q9934 {
    static int K;
    static int[] arr;        // 중위 순회 배열
    static StringBuilder[] levels;  // 각 레벨별 노드 값을 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine().trim());
        int nodeCount = (1 << K) - 1;  // 2^K - 1
        arr = new int[nodeCount];

        String[] parts = br.readLine().split(" ");
        for (int i = 0; i < nodeCount; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        levels = new StringBuilder[K];
        for (int i = 0; i < K; i++) {
            levels[i] = new StringBuilder();
        }

        build(0, nodeCount - 1, 0);

        for (int i = 0; i < K; i++) {
            bw.write(levels[i].toString().trim());
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    static void build(int start, int end, int level) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        levels[level].append(arr[mid]).append(" ");
        build(start, mid - 1, level + 1);
        build(mid + 1, end, level + 1);
    }
}
