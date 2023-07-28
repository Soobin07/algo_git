package beakjoon.silver;

import java.util.HashMap;
import java.util.Scanner;

public class Q25260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double mult_sum = 0D;
		double sum = 0D;
		
		HashMap<String, Double> map = new HashMap<>();
		map.put("A+", 4.5);
		map.put("A0", 4.0);
		map.put("B+", 3.5);
		map.put("B0", 3.0);
		map.put("C+", 2.5);
		map.put("C0", 2.0);
		map.put("D+", 1.5);
		map.put("D0", 1.0);
		map.put("F", 0.0);
		
		double tmp = 0D;	//학점
		String tmpStr = null;
		for(int i = 0 ; i < 20 ; i++) {
			tmpStr = sc.nextLine();
			String[] tmpArr = tmpStr.split(" ");
			tmp = Double.parseDouble(tmpArr[1]);
			String grd = tmpArr[2];
			if(map.containsKey(grd))  {
				mult_sum += map.get(grd)*tmp;
				sum += tmp;
			}
		}
		
		System.out.println(mult_sum / sum);
	}
}
