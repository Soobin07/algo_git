package beakjoon.bronze;

import java.util.Scanner;

public class Q5597 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] arr = new boolean[31];
		arr[0] = true;
		for(int i = 0 ; i < 28 ; i++) {
			arr[sc.nextInt()] = true;
		}
		
		for(int i = 1 ; i < 31 ; i++) {
			if(!arr[i])
				System.out.println(i);
		}
	}
}
