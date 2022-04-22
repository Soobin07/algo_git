package beakjoon.silver;

import java.util.Scanner;

public class Q2477 {
	static String input1 = "7\r\n" + 
			"4 50\r\n" + 
			"2 160\r\n" + 
			"3 30\r\n" + 
			"1 60\r\n" + 
			"3 20\r\n" + 
			"1 100";
	static String input2 = "7\r\n" + 
			"3 30\r\n" + 
			"1 60\r\n" + 
			"3 20\r\n" + 
			"1 100\r\n" + 
			"4 50\r\n" + 
			"2 160";
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(input1);
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();	   //1제곱m당 참외수
		int[] dstArr = new int[6]; //거리
		
		for(int i = 0 ; i < 6 ; i++) {
			sc.nextInt();
			dstArr[i] = sc.nextInt();
		}

		//가로/세로 max 찾기
		int max_even = 0;
		int max_odd = 0;
		for(int i = 0 ; i < 6 ; i++) {
			if(i % 2 == 0 && max_even < dstArr[i]) max_even = dstArr[i];
			else if(i % 2 == 1 && max_odd < dstArr[i]) max_odd = dstArr[i];
		}
		
		//구멍뚫린 부분 찾기
		int min_even = 0;
		int min_odd = 0;
		for(int i = 0 ; i < 6 ; i++) {
			int st = i-1 < 0 ? i+5 : i-1;
			int ed = i+1 >= 6 ? i-5 : i+1;
			if(i % 2 == 0) {
				if(max_odd == dstArr[st]+dstArr[ed]) {
					min_even = dstArr[i]; 
				}
			}else {
				if(max_even == dstArr[st]+dstArr[ed]) {
					min_odd = dstArr[i]; 
				}
			}
		}
		System.out.println(((max_even*max_odd)-(min_even*min_odd))*k);
	}
	
	//틀렸지만 근간이므로 원형보존
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(input2);
////		Scanner sc = new Scanner(System.in);
//		int k = sc.nextInt();	   //1제곱m당 참외수
//		int[] dirArr = new int[6]; //방향
//		int[] dstArr = new int[6]; //거리
//		int area = 0; 			   //면적
//		
//		for(int i = 0 ; i < 6 ; i++) {
//			dirArr[i] = sc.nextInt();
//			dstArr[i] = sc.nextInt();
//		}
//		
//		//동서, 남북 방향의 max 구하기
//		int max12 = 0;
//		int max34 = 0;
//		for(int i = 0 ; i < 6 ; i++) {
//			int di = dirArr[i];
//			int ds = dstArr[i];
//			if(di < 3 && dstArr[max12] < ds) {
//				max12 = i;
//			}else if(di > 2 && dstArr[max34] < ds) {
//				max34 = i;
//			}
//		}
//		//면적 구하기
//		area = dstArr[max12]*dstArr[max34];
//		
//		//뺄 면적 구하기
//		for(int i = -1 ; i < 2 ; i++) {
//			if(max12 + i < 0) dstArr[max12+6+i] = 0;
//			else if(max12 + i >= 6) dstArr[max12-6+i] = 0;
//			else dstArr[max12+i] = 0;
//			if(max34 + i < 0) dstArr[max34+6+i] = 0;
//			else if(max34 + i >= 6) dstArr[max34-6+i] = 0;
//			else dstArr[max34+i] = 0;
//		}
//		int smallArea = 0;
//		for(int i = 0 ; i < 6 ; i++) {
//			if(dstArr[i] != 0) {
//				smallArea = smallArea == 0 ? smallArea+dstArr[i] : smallArea*dstArr[i];
//			}
//		}
//		System.out.println((area-smallArea)*k);
//	}
}
