package sw.d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//주성님 코드
public class SWEA1979_2 {
	public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		//입력용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		//출력용
        int T = Integer.parseInt(br.readLine()), t = 0;		//T(테스트 케이스) 받고, t 선언, 초기화
        StringTokenizer st;	
        int[][] map = new int[16][16];		//맵 2개 (가로, 세로)
        int[][] map2 = new int[16][16];
        while (t++ < T) {		//t를 하나씩 더해서 T가 될 때 까지 
            st = new StringTokenizer(br.readLine());	//N과 K
            int N = Integer.parseInt(st.nextToken());	
            int M = Integer.parseInt(st.nextToken());
            for(int i=0; i<N; i++){		//맵 넣기
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++)map[i][j]=Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<N; i++){		//맵 복사
                for(int j=0; j<N; j++)map2[i][j]=map[j][i];	
            }
            int sum=0;		//답 선언, 초기화
            //맵을 2개 선언하면서 겉 for문을 하나로 통일하실 수 있었음
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++)if(map[i][j]==1){	//여기를 모르겠는데, 아마 for문 돌면서 저 조건일 때만 내려가는게 아닌가 싶음
                    int cnt=0;	//이 줄의 연속된 빈칸 숫자 세어주는 변수 선언, 초기화
                    while(j<N&&map[i][j]==1){	//j가 N보다 작을 때 까지 또는 검은색 칸이 나올 때 까지, 오른쪽으로 가면서 cnt를 늘려준다 
                        cnt++; j++;
                    }
                    if(cnt==M)sum++;	//검은 칸 또는 줄의 끝을 만나서 빠져나옴 -> cnt가 M이면 답에 +1해준다
                }
                for(int j=0; j<N; j++)if(map2[i][j]==1){	//아래는 동일
                    int cnt=0;
                    while(j<N&&map2[i][j]==1){
                        cnt++; j++;
                    }
                    if(cnt==M)sum++;
                }
            }
            bw.append("#"+t+" "+sum+"\n");
        }
        bw.flush();
    }
}
