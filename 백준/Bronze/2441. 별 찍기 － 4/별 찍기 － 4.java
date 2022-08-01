import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < N ; i++) {	//몇번째 줄?
			for(int j = 0 ; j < i ; j++) {
				sb.append(" ");
			}//띄어쓰기
			for(int j = i ; j < N ; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
