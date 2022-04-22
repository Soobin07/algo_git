package sw.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
//총점이 동일한 경우가 없다 해서 아래 방법 사용(score를 기억하는 방식)
public class SWEA1983 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input1983.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb =new StringBuffer();
		
		String[] grades = {"A+", "A0", "A-", "B+","B0","B-","C+","C0","C-","D0"};
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);	//학생 총 인원
			int k = Integer.parseInt(tmp[1]);	//몇번째 학생
			
			Double[] score = new Double[n];	//학생 성적 계산
			
			//학생 성적 총점 계산
			for(int i = 0 ; i < n ; i++) {
				tmp = br.readLine().split(" ");
				score[i] = Integer.parseInt(tmp[0])*0.35 +Integer.parseInt(tmp[1])*0.45 + Integer.parseInt(tmp[2])*0.2;
			}
			Double k_score=score[k-1];
			Arrays.sort(score, Collections.reverseOrder());
			
			sb.append("#").append(t).append(" ");
			int cnt = 0;
			for(int i = (n/10) ; i < n ; i += (n/10)) {
				if(k_score <= score[i]) cnt++;
				else break;
			}
			sb.append(grades[cnt]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
