package beakjoon.gold;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
//시간초과
public class Q2357_3 {
	static String input="10 4\r\n" + 
			"75\r\n" + 
			"30\r\n" + 
			"100\r\n" + 
			"38\r\n" + 
			"50\r\n" + 
			"51\r\n" + 
			"52\r\n" + 
			"20\r\n" + 
			"81\r\n" + 
			"5\r\n" + 
			"1 10\r\n" + 
			"3 5\r\n" + 
			"6 9\r\n" + 
			"8 10";
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt(); //정수 갯수
		int[] arr = new int[N];	//정수 담은 배열
		PriorityQueue<Integer> min = new PriorityQueue<>(); //최소값
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder()); //최대값
		
		int M = sc.nextInt(); //index쌍 갯수
		
		//arr 만들기
		for(int n = 0 ; n < N ; n++) {
			arr[n] = sc.nextInt();
		}
		
		//index쌍 풀기
		for(int m = 0 ; m < M ; m++) {
			int idxmin = sc.nextInt()-1;
			int idxmax = sc.nextInt()-1;
			
			for(int i = idxmin ; i < idxmax+1 ; i++) {
				min.add(arr[i]);
				max.add(arr[i]);
			}
			sb.append(min.peek()).append(" ").append(max.peek()).append("\n");
			min.clear();
			max.clear();
		}
		System.out.print(sb);
	}
}
