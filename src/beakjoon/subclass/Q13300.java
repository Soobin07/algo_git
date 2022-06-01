package beakjoon.subclass;

import java.util.Scanner;

public class Q13300 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int N = sc.nextInt(); //학생수
		 int K = sc.nextInt(); //한 방 최대 인원수
		 int[][] stds = new int[6][2];	//학생들을 학년 / 성별로 나눠 카운트
		 int ans = 0;	//필요한 방 count
		 
		 //학생 카운트
		 for(int n = 0 ; n < N ; n++) {
			 int s = sc.nextInt(); //성별
			 int y = sc.nextInt(); //학년
			 stds[y-1][s]++;
		 }
		 
		 for(int y = 0 ; y < 6 ; y++) {
			 for(int s = 0 ; s < 2 ; s++) {
				 ans += Math.ceil(stds[y][s]/(double)K);
			 }
		 }
		 System.out.println(ans);
	}

}
