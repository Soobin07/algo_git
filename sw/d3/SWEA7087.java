package sw.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA7087 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input7087.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T ; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] titles = new String[N];
			
			//타이틀 받기
			for(int n = 0 ; n < N ; n++) {
				titles[n] = br.readLine();
			}
			
			//A부터 정렬 (대문자 알파벳으로 시작한다 했으니 그냥 정렬)
			Arrays.sort(titles);
			
			//최대 찾기
			int cnt = 0;
			int index = -1;
			for(int n = 0 ; n <N ; n++) {
				char c = titles[n].charAt(0);	//첫글자 보기
				if(index+1 == c-'A') {
					index = c-'A';
					cnt++;
				}else if(index == c-'A') continue;
				else break;
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}
}
