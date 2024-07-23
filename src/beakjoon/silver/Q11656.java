package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Q11656 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			arr.add(str.substring(i, str.length()));
		}

		Collections.sort(arr);
		for (int i = 0; i < arr.size(); i++) {
			bw.append(arr.get(i) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
