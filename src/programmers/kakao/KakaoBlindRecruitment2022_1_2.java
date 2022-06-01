package programmers.kakao;

import java.util.Arrays;

// 2중 1문
public class KakaoBlindRecruitment2022_1_2 {
	static String[] id_list = {"muzi", "frodo", "apeach", "neo"};
	static String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
	static int k = 2;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(id_list, report, k)));
	}
	static public int[] solution(String[] id_list, String[] report, int k) {
        int counts = id_list.length;
        int[] answer = new int[counts];
        boolean[][] reported = new boolean[counts][counts];	//신고한사람-신고당한 사람을 2차원배열로
        String[] reportStr = new String[2];
        int repoId, repodId, sum;	//리포트한 id의 index, 리포트 당한 id의 index, 
        
        for(int i = 0 ; i < report.length ; i++){	//report를 확인
            repoId = -1;
            repodId = -1;
            reportStr = report[i].split(" ");
            for(int j = 0 ; j < id_list.length ; j++){
                if(reportStr[0].equals(id_list[j])) repoId = j;
            }
            for(int j = 0 ; j < id_list.length ; j++){
                if(reportStr[1].equals(id_list[j])) repodId = j;
            }
            reported[repoId][repodId] = true;
        }
        
        for(int i = 0 ; i < id_list.length ; i++){
            sum = 0;
            for(int j = 0 ; j < id_list.length; j++){
                if(reported[j][i]) sum++;
            }
            if(sum >= k){
                for(int j = 0 ; j < id_list.length; j++){
                    if(reported[j][i]) answer[j]++;
                }
            }
        }
        return answer;
    }
}
