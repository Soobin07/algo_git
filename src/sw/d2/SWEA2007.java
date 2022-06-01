package sw.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA2007 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input2007.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());	//테스트케이스 갯수
		for(int t = 1 ; t <= T ; t++) {
			String str = br.readLine();
			String pattern = "";
			boolean isPattern = false;
			int idx = 1;
			while(!isPattern) {
				pattern = str.substring(0, idx);
				if(pattern.equals(str.substring(idx, 2*idx))) {
					isPattern = true;
					break;
				}
				idx++;
			}
			
			sb.append("#").append(t).append(" ").append(pattern.length()).append("\n");
		}
		System.out.print(sb);
	}
}
