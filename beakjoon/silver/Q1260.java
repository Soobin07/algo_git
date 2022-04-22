package beakjoon.silver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Q1260 {
	static class Node implements Comparable<Node> {
		int value;
		int next;

		public Node(int value, int next) {
			this.value = value;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			if (this.value != o.value) {
				return this.value - o.value;
			} else {
				return this.next - o.next;
			}
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", next=" + next + "]";
		}
	}

	static Node[] lines;
	static boolean[] visited;
	static int N, M;
	static StringBuffer sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuffer();
		N = sc.nextInt();
		M = sc.nextInt();
		int V = sc.nextInt();

		lines = new Node[M * 2];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			lines[i] = new Node(a, b);
			lines[M + i] = new Node(b, a);
		}
		Arrays.sort(lines);

		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs(V);

		System.out.print(sb.toString());
	}

	static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		visited[num] = true;
		while (!queue.isEmpty()) {
			int n = queue.poll();
			sb.append(n).append(" ");
			for (int i = 0; i < M * 2; i++) {
				if (lines[i].value == n && !visited[lines[i].next]) {
					queue.add(lines[i].next);
					visited[lines[i].next] = true;
				}
			}
		}
	}

	static void dfs(int num) {
		if (visited[num])
			return;
		visited[num] = true;
		sb.append(num).append(" ");
		for (int i = 0; i < M * 2; i++) {
			if (lines[i].value == num && !visited[lines[i].next]) {
				dfs(lines[i].next);
			}
		}
	}
}
