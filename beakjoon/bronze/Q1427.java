package beakjoon.bronze;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q1427 {
	public static void main(String[] args) {
		//각 자리의 수를 배열에 담았다.
		//for문을 자리수만큼 돌리고, 배열에 n%10을 넣고, 
		//n/10을 이용하여 자리수를 줄여주는 방법을 사용했다

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int log = (int)Math.log10(n)+1;
		Integer[] l = new Integer[log];
		for(int i = 0 ; i < log ; i++) {
			l[i] = n%10;
			n /= 10;
		}
		Arrays.sort(l, Collections.reverseOrder());
		for(int i : l) {
			System.out.print(i);
		}
	}
}
