package beakjoon.silver;

import java.util.Scanner;

//내가 본 다른 사람 코드

//몇번 잘라진 것인지, 몇번 자르려 했는지를 재귀로 받고, StringBuffer도 함께 받고
//앞/뒤가 같다는 것을 이용하여, 앞까지 만든 것을, 스트링으로 받아두고, 가운데 부분을 여지껏 만든 만큼 띄우고, 그 다음 다시 첫번째 것을 복사해 붙여주고.. 
public class Q4779_2 {
	public static StringBuilder recur(int N,int cnt, StringBuilder sb) {
		if(cnt==N) {
			return sb;
		}
		String pre = sb.toString();
		int len = sb.length();
		for (int j = 0; j < len; j++) {
			sb.append(' ');
		}
		sb.append(pre);
		return recur(N,++cnt,sb);
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			sb.setLength(0);
			int cnt = 0;
			int N = sc.nextInt();
			sb.append('-');
			System.out.println(recur(N,cnt,sb).toString());
		}
		sc.close();
	}
}
