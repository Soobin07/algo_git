package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//A와 B2
//간단하게 S->T로 하려다 메모리 초과로 실패.
//S->T가 안된다면 T를 S로 만들 수 있나 확인하기로.
public class Q12919 {
	static String S, T, temp;
	static int ans;
	static StringBuffer sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();
		T = br.readLine();
		sb = new StringBuffer();

		ans = 0;
		solve(S, T);
		System.out.println(ans);
	}

	//dps 사용
	static void solve(String s, String t) {
		//s와 t가 같으면 '만들 수 있다'로 종료
		if (s.equals(t)) {
			ans = 1;
			return;
		}
		//둘의 길이가 같으면, 만들 수 없으므로 일단 넘어가기
		if (s.length() >= t.length())
			return;
		//만약 제일 뒤가 a면 그것만 잘라내고 다시 가보자 
		if (t.charAt(t.length() - 1) == 'A') {
			temp = t;
			temp = temp.substring(0, temp.length() - 1);
			solve(s, temp);
		}
		//만약 제일 앞이 B면 지우고 전체 반대로
		if (t.charAt(0) == 'B') {
			temp = t;
			temp = temp.substring(1, temp.length());
			//String을 반대로 하는 방법을 모르겠으니 StringBuffer 이용하자
			sb.append(temp);
			sb.reverse();
			temp = sb.toString();
			sb.setLength(0);
			solve(s, temp);
		}
	}
}
