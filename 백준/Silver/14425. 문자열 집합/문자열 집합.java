import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Set<String> s = new HashSet<>();
		for(int i = 0 ; i < N ; i++) {
			s.add(sc.next());
		}
		
		int cnt = 0;
		for(int i = 0 ; i < M ; i++) {
			String tmp = sc.next();
			if(s.contains(tmp)){
				cnt++;
				continue;
			}
		}
		System.out.println(cnt);
	}
}
