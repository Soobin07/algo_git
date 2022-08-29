import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int cnt = Integer.MAX_VALUE;
		for(int i = 0 ; i <= 1 ; i++) {	//어떤 문자로 다 채울거야?
			int tmp = 0;	//이 문자일 때는 이게 최대야
			for(int j = 0 ; j < s.length() ; j++) {	//앞부터 한글자씩 보자
				int c = s.charAt(j)-'0';
				//만약 맨 앞부터 바꿔야 하는거면?
				if(c != i) {
					if(j == 0) {
						tmp++;
					}else if(s.charAt(j-1)-'0' != c) {
						tmp++;
					}
				}
			}
			cnt = Math.min(tmp, cnt);	//둘중에 더 작은게 좋은거다
		}
		System.out.println(cnt);
	}
}
