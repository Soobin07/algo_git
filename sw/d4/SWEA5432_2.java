package sw.d4;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA5432_2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input5432.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int ans, cnt_l;
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1 ; t <= T ; t++) {
			//값 초기화
			cnt_l = 0;
			ans = 0;
			
			//쇠막대기와 레이저의 배치
			String line = sc.nextLine();
			
			for(int i = 0 ; i < line.length() ; i++) {
				if(line.charAt(i) == '(') {
					if(line.charAt(i+1) == ')') {	//arr[arr.length-1]은 여기 올일 없으니 처리 생략함
						ans += cnt_l;
						i++;
						continue;
					}
					cnt_l++;
				}else {
					cnt_l--;
					ans++;
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		sc.close();
	}
}
