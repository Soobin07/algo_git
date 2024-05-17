package beakjoon.bronze;

import java.util.Scanner;

//방 배정하기
public class Q14697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// ABC는 <= 50 이니 INT범위다
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		// N은 <=300이니 INT범위다
		int N = sc.nextInt();

		boolean flag = false; // 방 나누는 것이 가능한가?
		count: for (int a = 0; a <= N / A + 1; a++) {
			for (int b = 0; b <= N / B + 1; b++) {
				for (int c = 0; c <= N / C + 1; c++) {
					if (a * A + b * B + c * C == N) {
						flag = true;
						break count;
					}
				}
			}
		}

		if (flag)
			System.out.println(1);
		else
			System.out.println(0);
	}
}
