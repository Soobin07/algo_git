package beakjoon.bronze;

import java.util.Scanner;

//뒤집힌 덧셈
public class Q1357 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer X = new StringBuffer(sc.next());
		StringBuffer Y = new StringBuffer(sc.next());

		X.reverse();
		Y.reverse();

		int sum = Integer.parseInt(X.toString()) + Integer.parseInt(Y.toString());
		StringBuffer S = new StringBuffer(sum + "");
		S.reverse();

		System.out.println(Integer.parseInt(S.toString()));
	}
}
