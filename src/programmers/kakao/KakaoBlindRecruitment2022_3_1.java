package programmers.kakao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//그냥 아주 틀림. 근데 예쁘게 담았어
public class KakaoBlindRecruitment2022_3_1 {
	public static void main(String[] args) {
		int[] answer = {};

		//입력
		int[] fees;
		String[] records;

		fees = new int[]{180, 5000, 10, 600};
		records = new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		
//		fees = new int[]{120, 0, 60, 591};
//		records = new String[] {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
		
//		fees = new int[]{1, 461, 1, 10};
//		records = new String[] {"00:00 1234 IN"};

		

		//1. arr[입차시간, 출차시간, 차번호]
		//2. 
		
		int count = 0; //arr 갯수
		for(String str : records) { //arr갯수 구하기
			if(str.contains("IN")) count++; 
		}
		String[][] rec = new String[count][3]; //arr
		String[] strs;
		
		
		int idx=0;
		for(String str : records) {
			strs = str.split(" ");
			if(str.contains("IN")) {
				rec[idx][0] = strs[0];
				rec[idx][2] = strs[1];
				idx++;
			}
		}
		for(String str : records) {
			if(str.contains("OUT")) {
				strs = str.split(" ");
				for(int i = 0 ; i < rec.length ; i++) {
					if(rec[i][2].equals(strs[1]) && rec[i][1] == null){
						rec[i][1] = strs[0]; break;
					}
				}
			}
		}
		for(int i = 0 ; i < rec.length ; i++) {
			if(rec[i][1] == null) rec[i][1] = "23:59";
		}
		Set set = new HashSet();
		for(int i = 0 ; i < rec.length ; i++) {
			set.add(rec[i][2]);
		}
		String[] carNo = new String[set.size()];
		Iterator<String> it = set.iterator();
		for(int i = 0 ; i < carNo.length ;i++) {
			carNo[i] = it.next();
		}
		Arrays.sort(carNo);
		answer = new int[carNo.length];

		int[][] times = new int[carNo.length][2];
		int out, in, time, fee;
		for(int i = 0 ; i < rec.length ;i++) {
			for(int j = 0 ; j < carNo.length ; j++) {
				
			}
			out = Integer.parseInt(rec[i][1].split(":")[0])*60 + Integer.parseInt(rec[i][1].split(":")[1]);
			in = Integer.parseInt(rec[i][0].split(":")[0])*60 + Integer.parseInt(rec[i][0].split(":")[1]);
			time = out-in;
			fee = 0;
			if(time <= fees[0]) {
				fee += fees[1];
			}else {
				fee += fees[1];
				fee += ((time-fees[0])/fees[2])*600;
				if(((time-fees[0])%fees[2]) != 0) {
					fee+=600;
				}
			}
			for(int j = 0 ; j < carNo.length ; j++) {
				if(rec[i][2].equals(carNo[j])) {
					answer[j] += fee;
				}
			}
		}
		
		System.out.println(Arrays.deepToString(rec));

		System.out.println(Arrays.toString(answer));
	}
	
}
