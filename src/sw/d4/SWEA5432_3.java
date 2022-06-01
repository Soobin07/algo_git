package sw.d4;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//준혁 풀이
public class SWEA5432_3 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input5432.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		//() = (와 )의 길이 = 1 => 레이저
		//(( ... )) 길이가 1보다 크면 철근
		// 레이저를 쏘아서 잘려질 경우 겹쳐진 철근의 수 만큼 철근 조각이 생긴다
		
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1 ; t <= T ; t++) {
			int ans = 0;
			String line = sc.nextLine();
			List<Integer> stack = new ArrayList<>(); //스택
			List<Integer> laser = new ArrayList<>(); //레이저 정보
			int[] rebar = new int[line.length()]; //철근정보
			
			for(int i = 0; i < line.length(); i++){
	            if(line.charAt(i) == '(') stack.add(i); // push
	            else{
	                int end = i;
	                int start = stack.get(stack.size() - 1);
	                stack.remove(stack.size() - 1); // pop
	 
	                // 레이저임?
	                if(end - start == 1) laser.add(i);
	                // 레이저 아님 -> 철근 정보
	                else{
	                	ans++;
	                    for(int j = start; j < end; j++) rebar[j]++;
	                }
	            }
	        }
	        for(int i : laser) ans += rebar[i];
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		sc.close();
	}
}
