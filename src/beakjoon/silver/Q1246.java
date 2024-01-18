package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

//온라인 판매
public class Q1246 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 달걀
		int M = sc.nextInt(); // 고객
		// i번째 고객은 각자 달걀 하나를 Pi 가격 이하로 살 수 있음

		// 한 고객에게 두개 이상의 달걀은 팔지 않는다
		// 수익은 최대로 올리고 싶다
		// A 가격에 달걀을 판다고 하면 Pi가 A 가격보다 크거나 같은 모든 고객은 달걀을 산다
		// 최대 수익을 올릴 수 있는 달걀의 가장 낮은 가격 책정

		// 가격 받기
		int[] price = new int[M]; // 각 고객이 살 수 있는 달걀 최대값
		for (int i = 0; i < M; i++) {
			price[i] = sc.nextInt();
		}

		Arrays.sort(price);

		// 모든 값을 한번 돌려본다
		int sum_max = 0;
		int max_idx = 0;
		for (int i = 0; i < M; i++) {
			if (sum_max < price[i] * Math.min((M - i), N)) {
				sum_max = price[i] * Math.min((M - i), N);
				max_idx = i;
			}
		}

		System.out.println(price[max_idx] + " " + sum_max);
	}
}
