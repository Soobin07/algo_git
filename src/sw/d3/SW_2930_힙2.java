package sw.d3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SW_2930_힙2 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input2930.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			//우선순위 큐 Max우선순위로 만들기
			//1. Collections.reverseOrder사용
			//PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
			//2. 넣고 뺄 때 '-' 붙여서 정렬하기
			PriorityQueue<Integer> heap = new PriorityQueue<>();
			StringBuffer sb = new StringBuffer();
			sb.append("#").append(t);
			int N = sc.nextInt();
			for(int i = 0 ; i < N ; i++) {
				int op = sc.nextInt();
				if(op == 1) {
					heap.offer(-sc.nextInt());
				}else {
					if(heap.isEmpty()) {
						sb.append(" -1");
					}else {
						sb.append(" ").append(-heap.poll());
					}
				}
			}
			System.out.println(sb.toString());
		}
	}
}
