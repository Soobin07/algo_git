package beakjoon.bronze;

import java.util.Scanner;

public class Q14696 {
	static String input1 = "5\r\n" + 
			"1 4\r\n" + 
			"4 3 3 2 1\r\n" + 
			"5 2 4 3 2 1\r\n" + 
			"4 4 3 3 1\r\n" + 
			"4 3 2 1 1\r\n" + 
			"4 2 3 2 1\r\n" + 
			"4 4 3 2 1\r\n" + 
			"3 4 3 2\r\n" + 
			"5 4 4 2 3 1\r\n" + 
			"5 4 2 4 1 3";	//
	static String input2 = "4\r\n" + 
			"4 4 3 2 1\r\n" + 
			"4 1 4 3 2\r\n" + 
			"4 3 3 2 1\r\n" + 
			"4 4 3 3 3\r\n" + 
			"4 4 3 3 3\r\n" + 
			"4 3 4 3 2\r\n" + 
			"4 3 2 1 1\r\n" + 
			"3 3 2 1";
	static String input3 = "1\r\n" + 
			"3 4 4 4 \r\n" + 
			"4 4 4 4 4\r\n"; 
	static String input4 = "1\r\n" + 
			"22 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\r\n" + 
			"1 2";
	public static void main(String[] args) {
		Scanner sc = new Scanner(input2);
//		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		for(int n = 0 ; n < N ; n++) {
			String[] a = sc.nextLine().split(" ");
			String[] b = sc.nextLine().split(" ");
			
			int[] cnt_a = new int[5];
			int[] cnt_b = new int[5];
			
			for(int i = 1 ; i < a.length ; i++) {	//첫번째 수는 딱지 갯수임
				cnt_a[a[i].charAt(0)-'0']++; 
			}
			for(int i = 1 ; i < b.length ; i++) {
				cnt_b[b[i].charAt(0)-'0']++; 
			}
			
			for(int i = 4 ; i > 0 ; i--) {
				if(cnt_a[i] > cnt_b[i]) {
					System.out.println("A");
					break;
				}else if(cnt_a[i] < cnt_b[i]) {
					System.out.println("B");
					break;
				}else if(i == 1){
					System.out.println("D");
				}
			}
		}
	}
}
