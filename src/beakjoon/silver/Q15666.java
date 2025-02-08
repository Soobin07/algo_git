package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q15666 {
	static Integer[] number;
	static Set<String> array_set;
	static ArrayList<String> array;
	static int[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Set<Integer> number_set = new HashSet<>();
		ArrayList<Integer> number_arr = new ArrayList<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int tmp = 0;
		
		for (int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			if (!number_set.contains(tmp)) {
				number_set.add(tmp);
				number_arr.add(tmp);
			}
		}
		number = number_arr.toArray(new Integer[0]);
		Arrays.sort(number);

		select = new int[M];
		array_set = new HashSet<>();
		array = new ArrayList<>();
		
		find(M, 0, 0);
		
		for(int i = 0 ; i < array.size() ; i++) {
			bw.append(array.get(i)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static void find(int M, int sel_idx, int idx) {
		if (sel_idx >= M) {
			//int[] tmp = Arrays.copyOf(select, select.length);
			//Arrays.sort(tmp);
			if (!array_set.contains(Arrays.toString(select).replaceAll("[\\[,\\]]", ""))) {
				array_set.add(Arrays.toString(select).replaceAll("[\\[,\\]]", ""));
				array.add(Arrays.toString(select).replaceAll("[\\[,\\]]", ""));
			}
			return;
		}
		for(int i = idx ; i < number.length ; i++) {
			select[sel_idx] = number[i];
			find(M, sel_idx + 1, i);
		}
	}
}
