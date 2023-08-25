package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2529 {
	static long max, min;
	static int K;
	static boolean[] visit;
	static String[] simb;
	public static void main(String[] args) throws Exception {
		//사용할 변수 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//static 변수 초기화
		visit = new boolean[10];
		max = 0;
		min = Long.MAX_VALUE;
		
		//설정 받기
		K = Integer.parseInt(br.readLine());
		simb = br.readLine().split(" ");
		
		//첫번째 숫자를 0~9까지로 해서 시작해보기
		for(int i = 0 ; i < 10 ; i++) {
			visit[i] = true;
			find(i, 0, i+"");
			visit[i] = false;
		}
		
		//출력하기
		System.out.printf("%0"+(K+1)+"d\n", max);
		System.out.printf("%0"+(K+1)+"d", min);
	}
	
	static void find(int before_num, int simb_idx, String str) {
		//사용할 부등호의 idx가 K가 되면 숫자 확인 후 함수 종료
		if(simb_idx >= K) {
			max = Math.max(max, Long.parseLong(str));
			min = Math.min(min, Long.parseLong(str));
			return;
		}
		//before_num과 비교하여 부등호를 만족시키는 i를 찾는다
		for(int i = 0 ; i < 10 ; i++) {
			//아직 사용하지 않은 숫자 i 중에
			if(!visit[i]) {
				//부등호를 만족시키는 숫자가 있으면 다음 find로 넘어간다
				if(simb[simb_idx].charAt(0) == '>' && before_num > i) {
					//같은 숫자 다시 사용하지 않게 관리
					visit[i] = true;
					find(i, simb_idx+1, str+i);
					visit[i] = false;
				}
				else if(simb[simb_idx].charAt(0) == '<' && before_num < i){
					visit[i] = true;
					find(i, simb_idx+1, str+i);
					visit[i] = false;
				}
			}
		}
		//만약 for을 돌아서 부등호를 만족하는 i가 없을 경우 자연소멸
	}
}
