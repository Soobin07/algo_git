package sw.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA4789 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input4789.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= N ; t++) {
			char[] line = br.readLine().toCharArray();
			
			int sum = 0;
			int cnt = 0;
			for(int i = 0 ; i < line.length ; i++) {
				if(i <= sum) {
					sum+=(line[i]-'0');
				}else {
					int tmp = i-sum;
					cnt += tmp;
					sum += tmp+(line[i]-'0');
				}
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}
