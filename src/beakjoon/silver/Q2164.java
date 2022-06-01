package beakjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		
		//값 입력
		for(int i = 1 ; i <= N ; i++) {
			queue.add(i);
		}
		
		while(true) {
			int Q = queue.poll();
			if(queue.isEmpty()) {
				System.out.println(Q);
				break;
			}
			queue.add(queue.poll());
		}
	}
}
