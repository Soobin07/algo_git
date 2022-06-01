package beakjoon.bronze;

import java.util.Scanner;

public class Q10988 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str = sc.nextLine();
		
		char[] arr = str.toCharArray();
		
		int result = 1;
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i]!=arr[(arr.length-1)-i]) {
				result = 0;
				break;
			}
		}
		
		System.out.println(result);
	}
}
