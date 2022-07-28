import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuffer sb = new StringBuffer();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> map = new HashMap<>();
		Map<String, Integer> map_rev = new HashMap<>();
		
		for(int i = 0 ; i < N ; i++) {
			String tmp = br.readLine();
			map.put(i+1, tmp);
			map_rev.put(tmp, i+1);
		}	//입력
		
		for(int i = 0 ; i < M ; i++) {
			String tmp = br.readLine();
			char ch = tmp.charAt(0);
			if(ch >= '0' && ch <= '9') {	//숫자면
				sb.append(map.get(Integer.parseInt(tmp))).append("\n");
			}else {	//아니면
				sb.append(map_rev.get(tmp)).append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}
