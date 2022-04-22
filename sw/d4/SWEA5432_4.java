package sw.d4;

import java.io.FileInputStream;
import java.util.Scanner;

//쌤이 푸신 것 
//나랑 앞뒤 보는게 다르다
//cnt 해주는 부분이 다르다
//삼항연산자 사용

//고민해서 이해할만한 코드들은 주석을 달아라
public class SWEA5432_4 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input5432.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1 ; t <= T ; t++) {
			int ans = 0, 
				cnt = 0;	//막대기 갯수
			char[] data = sc.nextLine().toCharArray();
			for (int i = 0; i < data.length; i++) {
				if(data[i] == '(') {
					cnt++;
					continue;		//if-else 가 많이 나오면 코드 가독성이 떨어진다. 따라서.. 조건을 안주게 짤 수 있다면 그렇게 짜는게 더 좋다.
				}
					cnt--;
					ans+= data[i-1]=='(' ? cnt : 1;	
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}
