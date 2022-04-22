package beakjoon.silver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1966 {
	static String input1 ="3\r\n" + 
			"1 0\r\n" + 
			"5\r\n" + 
			"4 2\r\n" + 
			"1 2 3 4\r\n" + 
			"6 0\r\n" + 
			"1 1 9 1 1 1";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(input1);
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			Queue<int[]> queue = new LinkedList<>();	//0 : 처음순서, 1 : 중요도
			
			int N = sc.nextInt();	// N개 문서
			int M = sc.nextInt();	// 알고싶은 M번째 문서
			
			//문서 stack에 넣기
			for(int i = 0 ; i < N ; i++) {
				int[] tmp = new int[2];
				tmp[0] = i;	//처음 순서
				tmp[1] = sc.nextInt();	//중요도
				queue.add(tmp);
			}
			
			int order = 0;
			outer : while(true) {
				
				int[] tmp = queue.poll();	//지금 맨 앞에 있는 문서
				
				for(int[] arr : queue) {	//stack 안의 문서와 비교하여
					if(tmp[1] < arr[1]) {	//안쪽 문서의 중요도가 더 높을 때
						queue.add(tmp);	//맨 뒤로 넣어준다
						continue outer;
					}
				}
				
				//안에 중요도가 더 높은 문서가 없을 때
				order++;
				if(tmp[0] == M) break outer;
			}
			System.out.println(order);
		}
	}
}
