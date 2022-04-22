package sw.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA3499 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input3499.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb= new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T ; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			String[] cards = br.readLine().split(" ");
			String[] up = Arrays.copyOf(cards, (N/2)+(N%2));
			String[] down = Arrays.copyOfRange(cards, (N/2)+(N%2), cards.length);
			
			for(int i = 0 ; i < up.length ; i++) {
				cards[i*2] = up[i];
				sb.append(cards[i*2]).append(" ");
				if(i < down.length) {
					cards[2*i+1] = down[i];
					sb.append(cards[i*2+1]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
