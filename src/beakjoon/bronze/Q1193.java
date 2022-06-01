package beakjoon.bronze;

import java.util.Scanner;

public class Q1193 {
	public static void main(String[] args) {
		//1번 : 1/1						(1개)
		//2번-3번 : 1/2, 2/1				(2개)
		//4번-6번 : 3/1, 2/2, 1/3			(3개)
		//7번-10번 : 1/4, 2/3, 3/2, 4/1	(4개)
		//합이 2, 3, 4, 5 ... 가 된다. 
		//합이 .. 인 분수의 갯수는 합-1개
		//합이 짝수인 줄 : 합-1이 앞 , 합이 홀수인 줄 : 1이 앞
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();//x받기
		
		int line = 1; //1라인부터 시작
		int lineSum = 0; //앞 라인까지 수를 모두 더한 것 (몇번째인지 셀때 필요)
		while(line < x) {
			if(x >= lineSum &&x<=lineSum+line) { //라인최소값과 라인최대값 사이에 있으면 그 라인값이다
				break;
			}
			lineSum+=line;
			line++;
		}
		
		int before = x-lineSum-1;
		if(line%2 == 0) {
			System.out.println((before+1)+"/"+(line-before));
		}else {
			System.out.println((line-before)+"/"+(before+1));
			
		}
	}
}
