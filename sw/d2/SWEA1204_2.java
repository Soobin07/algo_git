package sw.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1204_2 {
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T;	
		T=Integer.parseInt(br.readLine()); //테스트 케이스 수
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int t = Integer.parseInt(br.readLine());	//테스트 케이스 번호
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] scores = new int[101]; //0~100까지
            
			//몇점을 몇번 받았는지 카운트한다
			while(st.hasMoreTokens()) {
				scores[Integer.parseInt(st.nextToken())]++;
			}
            
            //scores 배열 전체(0~100)를 돌며 최빈수 중 가장 큰 정수를 찾는다.
            int modeIdx = 0;	//scores의 index는 학생의 점수이다
            for(int i = 0 ; i < 101; i++){
                if(scores[modeIdx] <= scores[i]){
                    modeIdx = i;
                }
            }
            sb.append("#").append(t).append(" ").append(modeIdx).append("\n");
		}
        System.out.print(sb);
	}
}
