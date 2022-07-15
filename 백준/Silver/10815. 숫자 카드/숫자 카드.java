import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		Set<Integer> map = new HashSet<>();
		for(int i = 0 ; i < N ; i++) {
			map.add(sc.nextInt());
		}
		
		int M = sc.nextInt();
		for(int i = 0 ; i < M ; i++) {
			if(map.contains(sc.nextInt())) {
				sb.append(1).append(" ");
			}else {
				sb.append(0).append(" ");
			}
		}
		
		System.out.print(sb.toString());
	}
}
