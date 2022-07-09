import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int N = sc.nextInt();

		List<String>[] ageName = new ArrayList[201];
		//null제거
		for(int i = 0 ; i < 201 ; i++) {
			ageName[i] = new ArrayList<>();
		}
		
		//age에 맞는 곳에 추가
		for(int i = 0 ; i < N ; i++) {
			ageName[sc.nextInt()].add(sc.next());
		}
		
		//age.size!=0인 것만 출력
		for(int i = 0 ; i < 201 ; i++) {
			if(!ageName[i].isEmpty()) {
				for(int j = 0 ; j < ageName[i].size() ; j++) {
					sb.append(i).append(" ").append(ageName[i].get(j)).append("\n");
				}
			}
		}
		
		System.out.print(sb.toString());
		
	}
}
