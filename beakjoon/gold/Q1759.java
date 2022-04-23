package beakjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

public class Q1759 {
	static char[] sel;
	static char[] vow, con, all;	//vow : 모음, con : 자음, all : 전체  
	static int L, C, v, co;	//L : 암호 길이, C : 사용할만한 문자 갯수, v : 모음 갯수, co : 자음 갯수
	static StringBuffer sb = new StringBuffer();//답
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		sel = new char[L];
		vow = new char[C];
		con = new char[C];
		all = new char[C];
		
		for(int i = 0 ; i < C ; i++) {
			all[i] = sc.next().charAt(0);
		}//전체 저장
		
		Arrays.sort(all);//정렬
		
		String vowStr = "aieou";
		for(int i = 0 ; i < C ; i++) {
			if(vowStr.indexOf(all[i]) != -1) {
				vow[v++] = all[i];
			}else {
				con[co++] = all[i];
			}
		}//앞에서부터 나누기
		
		comb(0,0);
		System.out.print(sb.toString());
	}
	static void comb(int idx, int sidx) {
		if(sidx == L) {
			boolean isV = false;
			int cCnt = 0;
			outer : for(int i = 0 ; i < L ; i++) {	//sel 배열 확인
				if(!isV) {	//모음이 확인 안된 경우에만
					for(int j = 0 ; j < v ; j++) {	//모음확인
						if(sel[i] == vow[j]) {	//하나만 있으면 되니까, 한번 하면 바로 다음 sel 배열로 넘어가자구
							isV = true;
							continue outer;	
						}
					}
				}
				for(int j = 0 ; j < co ; j++) {	//자음 확인
					if(sel[i] == con[j]) {
						cCnt++;
						break;
					}
				}
				
			}
			if(isV && cCnt >= 2) {	//조건 만족하면 넣어라
				for(int i = 0 ; i < L ; i++) {
					sb.append(sel[i]);
				}
				sb.append("\n");
			}
			return;
		}
		if(idx == C) return;
		
		sel[sidx] = all[idx];
		comb(idx+1, sidx+1);
		comb(idx+1, sidx);
	}
}
