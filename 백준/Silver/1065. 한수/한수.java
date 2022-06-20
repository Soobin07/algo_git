import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 0;
		for(int i = 1 ; i <= N ; i++) {
			if(Math.log10(i) <= 1) {
				cnt++;
			}else {
				String str = Integer.toString(i);
				for(int j = 0 ; j < 10 ; j++) {
					boolean plus = true;
					boolean minus = true;
					for(int k = 1 ; k < str.length(); k++) {
						if(plus && str.charAt(k)-str.charAt(k-1) != j) {
							plus = false;
						}
						if(minus && str.charAt(k)+j != str.charAt(k-1)) {
							minus = false;
						}
					}
					if(plus || minus) cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
