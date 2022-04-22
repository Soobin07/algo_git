package beakjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1697 {
	static class Node{
		int x, time;
		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", time=" + time + "]";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int ans = Math.abs(N-K);	//+1 또는 -1만 해서 목적지에 도착하는 경우, 몇초걸리냐
		boolean[] dist = new  boolean[1000001];
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(N, 0));
		while(!q.isEmpty()) {
			Node n = q.poll();
			dist[n.x] = true;
			if(n.x == K) {
				ans = Math.min(ans, n.time);
				break;
			}
			
			if(n.x-1 >= 0 && !dist[n.x-1])
				q.add(new Node(n.x-1, n.time+1));
			if(n.x+1 <= 100000 && !dist[n.x+1])
				q.add(new Node(n.x+1, n.time+1));
			if(n.x*2 >= 0 && n.x*2 <= 100000 && !dist[n.x*2])
				q.add(new Node(n.x*2, n.time+1));
		}
		
		System.out.println(ans);
	}
}
