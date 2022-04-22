package programmers.kakao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class KakaoBlindRecruitment2022_3_3 {
	public static void main(String[] args) {
		int[] answer = {};

		//입력
		int[] fees;
		String[] records;
//		fees = new int[]{180, 5000, 10, 600};	//기본시간, 기본요금, 단위시간, 단위요금
//		records = new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		fees = new int[]{120, 0, 60, 591};
		records = new String[] {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
//		fees = new int[]{1, 461, 1, 10};
//		records = new String[] {"00:00 1234 IN"};

		//1. 사용 시간을 차별로 정리
		String[] in_times = new String[10000];
		int[] use_times = new int[10000];
		String[] tmps;
		for(String str : records) {
			tmps = str.split(" ");	//시간, 차번호, 입출차구분
			
			if(tmps[2].equals("IN")) {//입차시
				in_times[Integer.parseInt(tmps[1])] = tmps[0];
			}else {//출차시 : in_times와 비교하여 사용 시간 계산 & 입차 기록 초기화
				use_times[Integer.parseInt(tmps[1])] +=
						(Integer.parseInt(tmps[0].split(":")[0])*60
								+ Integer.parseInt(tmps[0].split(":")[1]))
						- (Integer.parseInt(in_times[Integer.parseInt(tmps[1])].split(":")[0])*60
								+ Integer.parseInt(in_times[Integer.parseInt(tmps[1])].split(":")[1]));
				in_times[Integer.parseInt(tmps[1])] = null;
			}
		}
		
		for(int i = 0 ; i < 10000 ; i++) { //in_times는 있고 out_times 는 없는 차 처리 (23:59에 out)
			if(in_times[i] != null) {
				use_times[i] += (23*60+59)
						- (Integer.parseInt(in_times[i].split(":")[0])*60 + Integer.parseInt(in_times[i].split(":")[1]));
				in_times[i] = null;
			}
		}
		
		//2. 사용 시간별로 요금 정리
		int[] car_fees = new int[10000];
		for(int i = 0 ; i < 10000 ; i++) {
			car_fees[i] = -1;
		}
		
		int time = 0;
		int count = 0;
		for(int i = 0 ; i < 10000 ; i++) {
			if(use_times[i] != 0) {
				count++;
				car_fees[i] = 0;
				if(use_times[i] < fees[0]) {
					car_fees[i] = fees[1];
				}else {
					car_fees[i] += fees[1];
					time = use_times[i]-fees[0]; 
					if( time > 0 ) {
						car_fees[i] += (time/fees[2])*fees[3];
						if(time%fees[2] != 0) car_fees[i] += fees[3]; 
					}
				}
			}
		}
		
		answer = new int[count];
		int idx = 0;
		for(int i = 0 ; i < 10000 ; i++) {
			int fee = car_fees[i];
			if(fee != -1) {
				answer[idx] = fee;
				idx++;
			}
		}
		
		System.out.println(Arrays.toString(answer));
	}
}
