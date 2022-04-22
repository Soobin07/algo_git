package beakjoon.bronze;

import java.util.Scanner;

public class Q2920 {
	//1-8 순서대로 = ascending, 8-1 = descending, 둘 다 아니면 mixed
	//1. 배열로 연주 순서 받는다
	//2. [0]이 1이면 이전+1인지 확인한다 -> 맞으면 ascending
	//3. [0]이 8이면 이전-1인지 확인한다 -> 맞으면 descending
	//4. 나머지 mixed
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		String result = "mixed";
		
		for(int i = 0 ; i < 8 ; i++) {
			arr[i] = sc.nextInt();
		}
		
		if(arr[0] == 1) {
			for(int i = 1 ; i < 8 ; i++) {
				if(arr[i]!=(i+1)) {
					break;
				}else if(i == 7) result = "ascending";
			}
		}else if(arr[0] == 8) {
			for(int i = 1 ; i < 8 ; i++) {
				if(arr[i]!=(8-i)) {
					break;
				}else if(i == 7) result = "descending";
			}
		}
		System.out.println(result);
	}
}
