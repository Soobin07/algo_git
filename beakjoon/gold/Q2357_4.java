package beakjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//시간초과
public class Q2357_4 {
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
	public static void main(String[] args) throws Exception{
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //정수 갯수
		int[] arr = new int[N];	//정수 담은 배열
		PriorityQueue<Integer> min = new PriorityQueue<>(); //최소값
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder()); //최대값
		
		int M = Integer.parseInt(st.nextToken()); //index쌍 갯수
		
		//arr 만들기
		for(int n = 0 ; n < N ; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		
		//index쌍 풀기
		for(int m = 0 ; m < M ; m++) {
			st = new StringTokenizer(br.readLine());
			int idxmin = Integer.parseInt(st.nextToken())-1;
			int idxmax = Integer.parseInt(st.nextToken())-1;
			
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
