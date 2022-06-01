package beakjoon.gold;

import java.util.Scanner;
//시간초과
public class Q2357_2 {
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
		int[] maxs = new int[N]; //그 index까지 최대값 담을 배열
		int[] mins = new int[N]; //그 index까지 최솟값 담을 배열
		
		int M = sc.nextInt(); //index쌍 갯수
		
		//arr 만들기
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int n = 0 ; n < N ; n++) {
			arr[n] = sc.nextInt();
			
			//max 담아주기
			if(max < arr[n]) {
				max = arr[n];
			}
			maxs[n] = max;
			//min 담아주기
			if(min > arr[n]) {
				min = arr[n];
			}
			mins[n] = min;
		}
		
		//index쌍 풀기
		for(int m = 0 ; m < M ; m++) {
			int idxmin = sc.nextInt()-1;
			int idxmax = sc.nextInt()-1;
			
			//배열에서 찾기
			//최솟값
			if(mins[idxmin] != mins[idxmax]) {	//최솟값이 변하였을 때
				sb.append(mins[idxmax]).append(" ");
			}else {	//안변했을 때
				if(mins[idxmin] == arr[idxmin]) {	//제일 앞 본인이 최소값일때
					sb.append(arr[idxmin]).append(" ");
				}else {
					int tmp = idxmin;
					for(int i = idxmin ; i < idxmax+1 ; i++) {
						if(arr[tmp] > arr[i]) tmp = i;
					}
					sb.append(arr[tmp]).append(" ");
				}
			}
			//최댓값
			if(maxs[idxmin] != maxs[idxmax]) {	//최대값이 변했을 때
				sb.append(maxs[idxmax]).append("\n");
			}else {	//안변했을 때
				if(maxs[idxmin]== arr[idxmin]) {	//제일 앞 본인이 최대값일때
					sb.append(arr[idxmin]).append("\n");
				}else {
					int tmp = idxmin;
					for(int i = idxmin ; i < idxmax+1 ; i++) {
						if(arr[tmp] < arr[i]) tmp = i;
					}
					sb.append(arr[tmp]).append("\n");
				}
			}
		}
		System.out.print(sb);
	}
}
