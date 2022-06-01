package beakjoon.bronze;

import java.util.Scanner;

public class Q7568 {
	public static void main(String[] args) {
		//키, 몸무게 전부 크면 더 크다
		//a의 키, 몸무게를 전체 키,몸무게와 비교하여 둘 다 a에 비해 큰 사람 숫자를 센다
		//사람 숫자가 적은 수를 1등으로 한다
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] bigger = new int[n];
		int[] weight = new int[n];
		int[] height = new int[n];
		
		for(int i = 0 ; i < n ; i ++) {
			weight[i] = sc.nextInt();
			height[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(weight[i] < weight[j] && height[i] < height[j]) bigger[i]++;
			}
		}
		
		for(int i : bigger) {
			System.out.print((i+1)+" ");
		}
			
	}
}
