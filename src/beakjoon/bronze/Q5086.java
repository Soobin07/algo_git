package beakjoon.bronze;

import java.util.Scanner;

//약수와 배수
public class Q5086 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int A = 0;
		int B = 0;
		while(true) {
			String ans = "neither";
			A = sc.nextInt();
			B = sc.nextInt();
			if(A == 0 && B == 0) {
				break;
			}
			if(A%B == 0) {
				ans = "multiple";
			}else if(B%A == 0) {
				ans = "factor";
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
}
