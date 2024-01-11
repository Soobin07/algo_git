package beakjoon.bronze;

import java.util.Scanner;

//0 = not cute / 1 = cute
public class Q10886 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[] ans = new int[2];
		for(int i = 0 ; i < cnt ; i++) {
			ans[sc.nextInt()]++;
		}
		
		System.out.print("Junhee is ");
		if(ans[0] > ans[1]) {
			System.out.print("not ");
		}
		System.out.println("cute!");
	}
}
