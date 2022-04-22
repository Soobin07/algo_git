package programmers.kakao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 2중 1문
public class KakaoBlindRecruitment2022_1_3 {
	static String[] id_list = {"muzi", "frodo", "apeach", "neo"};
	static String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
	static int k = 2;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(id_list, report, k)));
	}
	static public int[] solution(String[] id_list, String[] report, int k) {
		
        int[] answer = new int[id_list.length];
        Set<String> set = new HashSet<String>(Arrays.asList(report)); //set으로 report의 중복 없앰
        int[] reported = new int[id_list.length];
        report = set.toArray(new String[0]);
        
        for(int i = 0 ; i < report.length ; i++) {
        	String repId = report[i].split(" ")[1];
        	for(int j = 0 ; j < id_list.length ; j++) {
        		if(repId.equals(id_list[j])) {
        			reported[j]++;
        		}
        	}
        }
        for(int i = 0 ; i < reported.length ; i++) {
        	if(reported[i] >= k) {
        		String repId = id_list[i];
        		for(int j = 0 ; j < report.length ; j++) {
        			String[] strs = report[j].split(" ");
        			if(repId.equals(strs[1])) {
        				for(int l = 0 ; l < id_list.length ; l++) {
        					if(strs[0].equals(id_list[l])) answer[l]++;
        				}
        			}
        		}
        	}
        }
        
        return answer;
    }
}
