package sw.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA4047 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input4047.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		int t = T;
		test : while(t-->0) {
			String line = br.readLine();
			int[][] cards = new int[4][13];
			int[] card_cnt = new int[4];
			sb.append("#").append(T-t).append(" ");

			for(int i = 0 ; i < line.length() ; i+= 3) {
				String sub = line.substring(i, i+3);
				
				int tmp = Integer.parseInt(sub.substring(1));
				boolean flag=false;
				int index = -1;
				switch (sub.charAt(0)) {
				case 'S': index = 0; break;
				case 'D': index = 1; break;
				case 'H': index = 2; break;
				case 'C': index = 3; break;
				}
				if(cards[index][tmp-1] == 1) {
					flag = true; 
				}
				if(flag) {
					sb.append("ERROR").append("\n");
					continue test;
				}
				cards[index][tmp-1]++;
				card_cnt[index]++;
			}
			for(int i = 0 ; i < 4 ; i++) {
				sb.append(13-card_cnt[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
