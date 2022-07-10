import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		List<Long> list = new ArrayList<>();	//수열
		for(int i = 0 ; i < 3 ; i++) {
			list.add(1L);
		}
		
		//tc갯수
		int T = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < T ; t++) {
			//정삼각형 몇개까지?
			int N = Integer.parseInt(br.readLine());
			if(N > list.size()) {
				for(int i = list.size() ; i < N ; i++) {
					list.add(list.get(i-2)+list.get(i-3));
				}
			}
			sb.append(list.get(N-1)).append("\n");
		}
		System.out.print(sb.toString());
	}
}
