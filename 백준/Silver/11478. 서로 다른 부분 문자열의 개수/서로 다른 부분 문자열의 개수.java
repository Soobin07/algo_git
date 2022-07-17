import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		Set<String> set = new HashSet<>();
		//앞부분, 끝부분 정하기
		for(int i = 0 ; i < s.length() ; i++) {	//시작
			for(int j = i+1 ; j <= s.length() ; j++) {	//끝
				if(!set.contains(s.substring(i,j))) {	//없으면
					set.add(s.substring(i, j));
				};
			}
		}
		System.out.println(set.size());
	}
}
