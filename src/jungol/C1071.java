package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class C1071 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] input = new int[sc.nextInt()];
		for(int i = 0 ; i < input.length ; i++) {
			input[i] = sc.nextInt();
		}
		
		int stnd = sc.nextInt();
		
		Arrays.sort(input);
		
		int small = 0;
		int big = 0;
		
		//약수
		for(int i = 0 ; i < input.length ; i++) {
			if(input[i] > stnd) break;
			if(stnd%input[i] == 0) small += input[i];
		}
		
		//배수
		for(int i = 0 ; i < input.length ; i++) {
			if(input[i]%stnd == 0) big += input[i];
		}
		
		System.out.println(small);
		System.out.println(big);
	}
}
