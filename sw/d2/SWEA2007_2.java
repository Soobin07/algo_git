package sw.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2007_2 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input2007.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		int t = T;
		while(t-->0) {
			int ans = 0;	//패턴 길이
			char[] line = br.readLine().toCharArray();	//문자열
			char[] ptn = new char[10];	//패턴배열
			
			for(int i = 0 ; i < line.length ; i++) {	//라인 돌리기
				char ch = line[i];	//현재 글자
				if(!hasChar(ch, ptn)) {	//없는 글자면 패턴에 추가
					ptn[ans++] = ch;
					continue;
				}
				//있는 글자면 비교
				if(isPattern(ptn, line, ans, i)) break;
				ptn[ans++] = ch;
			}
			sb.append("#").append(T-t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static boolean hasChar(char c, char[] arr) {
		for(char ch : arr) {
			if(ch == c) return true;
		}
		return false;
	}
	static boolean isPattern(char[] pattern, char[] text, int index, int start) {
		int ptn_idx = 0;
		for(int i = start ; i < start+10 ; i++) {
			if(text[i] != pattern[ptn_idx]) return false;
			ptn_idx++;
			if(ptn_idx == index) ptn_idx = 0;
		}
		return true;
	}
}
