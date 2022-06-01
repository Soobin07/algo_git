package sw.d3;

import java.util.Scanner;

public class SWEA1493 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input1493.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			sb.append("#").append(t).append(" ");
			
			int[] vals = {sc.nextInt(), sc.nextInt()};	//p, q
			int[][] dis = new int[2][2];				//p, q가 나오는 좌표
			
			//&연산
			for(int i = 0 ;i < 2 ;i++) {
				int val = vals[i];		//p, q의 값
				int line = 1;
				while(true) {
					if(line*(line+1)/2 >= val) break;
					line++;
				}
				
				//y값	= val-이전 최대값
				dis[i][1] = val - ((line-1)*line/2);
				//x값	= 라인+1 - y값
				dis[i][0] = line+1 - dis[i][1];
			}
			
			//+연산 ==> dis의 0번 index가 유효한 좌표
			dis[0][0] += dis[1][0];	//x좌표
			dis[0][1] += dis[1][1];	//y좌표
			
			//#연산
			int line = dis[0][0] + dis[0][1] -1 ;
			int ans = (line * (line + 1))/2 - (line-dis[0][1]);
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
