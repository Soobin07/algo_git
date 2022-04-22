package programmers.kakao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//답을 읽고 풀었는데도, 0:0인 경우가 해결이 안됨. 다시
public class KakaoBlindRecruitment2022_3_2 {
	public static void main(String[] args) {
		int[] answer = {};

		//입력
		int[] fees;
		String[] records;
//		fees = new int[]{180, 5000, 10, 600};	//기본시간, 기본요금, 단위시간, 단위요금
//		records = new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
//		fees = new int[]{120, 0, 60, 591};
//		records = new String[] {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
		fees = new int[]{1, 461, 1, 10};
		records = new String[] {"00:00 1234 IN"};

		int[] in_time = new int[10000];
		int[] total_fee = new int[10000];	//시간에서 요금 계산하는 용도
		int time;
		
		String[] tmp;	//records의 시간, 번호, 인아웃을 나누는 용도의 배열
		for(String str : records) {
			tmp = str.split(" ");	//시간, 번호, 인아웃
			if(tmp[2].equals("IN")) {	//입차일 때 in_time에 넣기
				in_time[Integer.parseInt(tmp[1])] = Integer.parseInt(tmp[0].split(":")[0])*60+Integer.parseInt(tmp[0].split(":")[1]);
			}else {	//out일 때 시간 += out_time - in_time 하여 총 이용 시간 넣기 && 사용한 in_time 정리
				total_fee[Integer.parseInt(tmp[1])] += (Integer.parseInt(tmp[0].split(":")[0])*60+Integer.parseInt(tmp[0].split(":")[1])) - in_time[Integer.parseInt(tmp[1])];
				in_time[Integer.parseInt(tmp[1])] = 0;
			}
		}

		time = 0; //시간->분 계산 용도
		for(int i = 0 ; i < 10000 ; i++) {	//in time은 있는데 out time이 없는 차 처리 (23:59 출차처리)
			if(in_time[i] != 0) {
				total_fee[i] += (23*60+59) - in_time[i];
				System.out.println("차 번호 : "+i);
			}
		}
		
		int count = 0; //answer의 length
		time = 0;		//주차장이 사용된 시간
		for(int i = 0 ; i < 10000 ; i++) {	//total_time별 요금 정리
			time = total_fee[i];
			if(time != 0) {
				count++;
				if(time > fees[0]) {
					total_fee[i] = fees[1];
					time -= fees[0];
					if(time > 0) {
						total_fee[i] += (time/fees[2])*fees[3];
						if(time%fees[2] > 0) total_fee[i] += fees[3];  
					}
				}else {
					total_fee[i] = fees[1];
				}
			}
		}
		
		answer = new int[count];
		int idx = 0 ; //answer의 index
		for(int i = 0 ; i < 10000 ; i++) {	//answer배열 값 넣기
			if(total_fee[i] != 0) {
				answer[idx] = total_fee[i];
				idx++;
			}
		}
		
		System.out.println(Arrays.toString(answer));
	}
	
}
