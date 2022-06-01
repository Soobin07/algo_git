package sw.d3;

import java.io.FileInputStream;
import java.util.Scanner;

//for문
public class SWEA7102 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input7102.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			//1. for문 사용
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] count = new int[N+M+1];
			
			//합 count
			for(int i = 1 ; i < N+1 ; i++) {
				for(int j = 1 ; j < M+1 ; j++) {
					count[i+j]++;
				}
			}
			
			//빈도수가 높은 count 구하기
			int m_count = 0; //
			for(int i = 2 ; i < count.length ; i++) {
				if(count[i] > m_count) m_count = count[i];
			}
			//빈도수 같은 수 answer에 더해주기
			sb.append("#").append(t).append(" ");
			for(int i = 2 ; i < count.length ; i++) {
				if(m_count == count[i]) sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
