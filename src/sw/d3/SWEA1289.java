package sw.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//앞에것과만 비교하면 되니까!! beforeNum, tmpNo != beforeNum 대신, 앞의 값과 xor연산하여 훌 수 있다.
public class SWEA1289 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/sw/input1289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int cnt = 0;
			String ori = br.readLine();	//메모리 원래 값
			
			int beforeNum = 0;	//초기화 (초기 값이 전부 0이니, 처음에 0은 pass)
			for(int i = 0 ; i < ori.length() ; i++) {
				int tmpNo = ori.charAt(i)-'0';
				if(tmpNo != beforeNum) {
					cnt++;
					beforeNum = tmpNo; 
				}
			}
			
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}
}
