package beakjoon.bronze;

import java.util.Scanner;

public class Q10798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		char[][] arr = new char[5][];
		
		int max = 0;
		for(int i = 0 ; i < 5 ; i++) {
			String tmp = sc.nextLine();
			arr[i] = tmp.toCharArray();
			max = Math.max(max, tmp.length());
		}
		
		for(int i = 0 ; i < max ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				if(arr[j].length > i) {
					sb.append(arr[j][i]);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
