package sw.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA5356 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input5356.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1; t <=T ; t++) {
			sb.append("#").append(t).append(" ");

			char[][] arr = new char[5][];
			//여기서 j의 max를 잡아줄 수 있음
			for(int i = 0 ; i < 5 ; i++) {
				String line = sc.nextLine();
				arr[i]=line.toCharArray();
			}
			
			for(int j = 0 ; j < 15 ; j++) {
				for(int i = 0 ; i < 5 ; i++) {
					if(arr[i].length > j) {
						sb.append(arr[i][j]);
					}
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
