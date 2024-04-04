package beakjoon.bronze;

import java.util.Scanner;

//이칙연산
public class Q15726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double A = sc.nextInt();
		double B = sc.nextInt();
		double C = sc.nextInt();
		double ans = A * Math.max(B, C) / Math.min(B, C);
		System.out.println((int) ans);

		// 1e-9 이하의 오차로 인해 출력이 달라지는 입력은 주어지지 않는다.
		// 를 제대로 이해하지 못해서 4번 틀렸다.
		// 나는 첫 수에 1D를 곱해서 double화 해준 다음 다음 계산들을 하면 될 것 이라 생각했으나
		/*
		 	1. 모든 변수를 int로 받은 후 
			int ans1 = (int) (1D * (A / B) * C);
			int ans2 = (int) (1D * (A * B) / C);
			이 코드가 틀린 이유 : ans1의 A/B에서 오차가 크게 날 수 있다 (int로 형을 바꾸면서 소숫점을 버리기 때문에 허용오차 이상의 오차가 생길 수 있다) 
		 */
		/*
		 	2. 모든 변수를 int로 받은 후 
		 	int ans = (A * Math.max(B, C) / Math.min(B, C);
		 	이 코드가 틀린 이유 : same. 나눗셈을 int로 한다.
		 */
		//틀린 코드를 자세히 읽지 않아 생긴 문제이다. 앞으로는 조건을 조금 더 잘 읽어야지.
		//2에 제일 앞 A에 1D를 곱하여 다음 계산을 해도 정답이 나왔네. 내가 실수를 했다. 아주 많이.  
	}
}
