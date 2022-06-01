package sw.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

//실제로 바꾸지 말고, 순서만 바꿔서 출력해보자
public class SWEA3499_2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input3499.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb= new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T ; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			String[] cards = br.readLine().split(" ");
			
			int f = 0;
			int s = (N+1)/2;
			boolean flag = true;
			for(int i = 0 ; i < N ; i++) {
				sb.append(flag?cards[f++]:s>=N?"":cards[s++]).append(" ");
				flag = !flag;
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
