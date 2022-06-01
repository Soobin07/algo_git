package beakjoon.silver;

import java.util.Scanner;

//이것도 처음부터 246913 (2*n의 최대) 개의 배열을 만들어서, prime인지 확인하고
//해당 숫자까지 prime의 갯수를 세어, 2n개일때까지의 prime 갯수 - n개일때까지 prime 갯수 를 하여 프린트한 사람이 있다.
public class Q4948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n;
		while ((n = sc.nextInt()) != 0) {
			int cnt = 0;
			for (int i = n + 1; i <= 2 * n; i++) {
				boolean flag = true;
				for (int j = 2; j * j <= i; j++) {
					if (i % j == 0) {
						flag = false;
						break;
					}
				}
				if(flag) cnt++;
			}
			System.out.println(cnt);
		}
	}
}
