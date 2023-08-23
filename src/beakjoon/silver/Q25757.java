package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q25757 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> visit = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		int p_cnt = 4;
		if(game.equals("Y")) {
			p_cnt = 2;
		}else if(game.equals("F")) {
			p_cnt = 3;
		}

		ArrayList<String> names = new ArrayList<>();
		int game_cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			String name = br.readLine();
			if(!visit.contains(name)) {
				visit.add(name);
				names.add(name);
			}
			if(names.size() == p_cnt - 1) {
				game_cnt++;
				names.clear();
			}
		}
		System.out.println(game_cnt);
	}
}
