import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int sum = 0;
		int st = 0;
		boolean flag = true;	//true : 그대로
		for(int i = 0 ; i < str.length() ; i++) {
			char ch = str.charAt(i);
			if(ch == '+' || ch == '-') {
				int tmp = Integer.parseInt(str.substring(st, i));
				if(!flag) {
					tmp *= -1;
				}
				sum += tmp;
				st = i+1;
				if(ch == '-') {
					flag = false;
				}
			}
		}
		//마지막 숫자 처리
		int tmp = Integer.parseInt(str.substring(st, str.length()));
		if(!flag) {
			tmp *= -1;
		}
		sum += tmp;
		
		System.out.println(sum);
	}
}
