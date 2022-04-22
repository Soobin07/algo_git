package beakjoon.bronze;

import java.util.Scanner;

//층/호 제한 없을때는?
//https://loyog.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EC%9E%90%EB%B0%94-2775%EB%B2%88-%EB%B6%80%EB%85%80%ED%9A%8C%EC%9E%A5%EC%9D%B4-%EB%90%A0%ED%85%8C%EC%95%BC?category=669669
//재귀함수 이용하여 풀 수 있다
public class Q2775_2 {
//	static String input1 = "2\n1\n3\n2\n3";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(input1);
		int tc = sc.nextInt();
		while(tc-- > 0) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(getREsidents(k, n));
		}
	}
	static int getREsidents(int k , int n) {
		//0층에는 n 반환
		if(k == 0 ) return n;
		else {
			int r = 0;
			//1층부터는 아래 층의 n호 까지의 인원수 더한 값 반환
			for(int i = 1 ; i <= n ; i++) {
				r += getREsidents(k-1, i);
			}
			return r;
		}
	}
}
