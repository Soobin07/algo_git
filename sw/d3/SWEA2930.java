package sw.d3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA2930 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = sc.nextInt();
		
		for(int t = 1 ; t <= T ; t++) {
			sb.append("#").append(t).append(" ");
			int N = sc.nextInt();
			
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			int ans = -1;
			
			for(int n = 0 ; n < N ; n++) {
				int sel = sc.nextInt();
				if(sel == 1) {
					pq.add(sc.nextInt());
				}else {
					if(pq.peek() == null) {
						sb.append(-1).append(" ");
					}else {
						sb.append(pq.poll()).append(" ");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
