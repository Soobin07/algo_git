package beakjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1 ; i <= N ; i++) {
			queue.add(i);
		}
		
		int cnt = 0;
		StringBuffer ans = new StringBuffer();
		ans.append("<");
		while(!queue.isEmpty()) {
			int Q = queue.poll();
			if(++cnt == K) {
				ans.append(Q).append(", ");
				cnt = 0;
			}else {
				queue.add(Q);
			}
		}
		ans.setLength(ans.length()-2);
		ans.append(">");
		System.out.println(ans.toString());
	}
}
