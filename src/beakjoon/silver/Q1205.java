package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

//등수 구하기
public class Q1205 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 리스트에 있는 점수
		int score = sc.nextInt(); // 태수의 점수
		int P = sc.nextInt(); // 리스트에 올라갈 수 있는 점수의 개수

		// 리스트 받기
		int[] list = new int[P];
		Arrays.fill(list, -1);
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}

		int ans = -1;
		// list = 반 오름 차순으로 정리되어 있음
		for (int i = 1; i <= P; i++) {
			// 만약 i등 점수가 태수의 점수보다 낮으면
			if (list[i - 1] < score) {
				// 태수가 i등임
				ans = i;
				break;
			} else if (list[i - 1] > score) {
				// i등 점수가 태수의 점수보다 높으면 그냥 넘어간다
				continue;
			} else if (list[i - 1] == score) {
				// i등 점수와 태수의 점수가 같으면
				// 만약 i등이 가장 끝이면 i등에 들 수 없다.
				if (list[P - 1] == list[i - 1]) {
					break;
				}
				ans = i;
				break;
			}
		}

		System.out.println(ans);
	}
}
