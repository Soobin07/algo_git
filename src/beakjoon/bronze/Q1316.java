package beakjoon.bronze;

import java.util.Scanner;

public class Q1316 {
	public static void main(String[] args) {
		//알파벳이 사용 되었는지, 직전에 사용되었는지를 확인하였다
		//알파벳의 갯수를 담을 수 있는 배열을 사용하여, 알파벳이 나오면 그 글자의 자리수를 해당 알파벳의 배열에 넣어주었고,
		//다음 그 알파벳이 등장하였을 때, 바로 직전이면 자리수를 새로운 수로 업데이트 하였고
		//이전에 사용되고 다른 글자가 나온 후 다시 사용된 경우에는 해당하는 단어가 될 수 없으니, continue로 다음 단어로 넘어갔다.
		
		Scanner sc = new Scanner(System.in);
		int count = Integer.parseInt(sc.nextLine());
		int result = 0;
		outer: for(int i = 0 ; i < count ; i++) {
			String str = sc.nextLine();
			int[] alphabet = new int[26];
			for(int j = 1 ; j <= str.length() ; j++) {
				int before = alphabet[str.charAt(j-1)-'a'];
				if(before == 0 || before == j-1) alphabet[str.charAt(j-1)-'a'] = j;
				else continue outer; 
			}
			result++;
		}
		System.out.println(result);
	}
}
