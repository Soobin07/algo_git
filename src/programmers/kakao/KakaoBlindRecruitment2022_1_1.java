package programmers.kakao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// iterator의 위치에 주의
public class KakaoBlindRecruitment2022_1_1 {
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
        Iterator<String> it = set.iterator();
        
        //report 당한 id를 하나씩 id_list에서 순서를 찾아서 해당 순서의 reported에 신고 횟수를 +1해줌
        while(it.hasNext()){
            String repId = ((it.next()).split(" "))[1];
            for(int i = 0 ; i < id_list.length ; i++){
                if(repId.equals(id_list[i])) reported[i]++;
            }
        }
        
        //report된 사람 이름 가져오기
        for(int i = 0 ; i < reported.length ; i++){
        	it = set.iterator();
            if(reported[i] >= k){ //k명 이상에게 신고당했으면
                String str = id_list[i];
                while(it.hasNext()){//그 사람을 신고한 사람들을 찾는다
                    String[] strs = (it.next()).split(" ");
                    if(strs[1].equals(str)){ //신고당한 사람
                        for(int j = 0 ; j < id_list.length ; j++){
                            if(id_list[j].equals(strs[0])){ //신고한 사람
                                answer[j]++; //신고한 사람 index에 +1
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}
