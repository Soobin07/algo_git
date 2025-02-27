package beakjoon.silver;

import java.util.Scanner;

public class Q1817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 책의 개수
		int M = sc.nextInt(); // 최대 무게

		// 차례대로 넣는다
		int bCnt = 0; // 박스 갯수
		int sum = 0; // 현재 박스에 들어간 책 무게
		for (int i = 0; i < N; i++) {
			int bWeight = sc.nextInt();
			// 현재 박스에 들어가는가?
			if (sum + bWeight <= M) {
				sum += bWeight;
			} else {
				// 넘친다 = 다음 박스에 넣는다
				bCnt++;
				sum = bWeight;
			}
		}

		// 마지막 박스에 뭔가 들어있나? 들어있으면 이 박스까지 사용해야 한다.
		if (sum > 0)
			bCnt++;
		System.out.println(bCnt);

	}
}
