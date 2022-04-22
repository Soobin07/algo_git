package sw.d2;

import java.io.IOException;
import java.util.Scanner;

//홍주성님 코드
public class SWEA1974_2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt(), t=0;		//테스트케이스 수 T, 현재 케이스 t
        int[][] board = new int[9][9];  //스도쿠 보드 미리 만들기
        while(t++<T){		//t++ 한 것이 T 와 같아질 때 부터 종료
            int ans = 1;	//true를 기본값으로
            for(int i=0; i<9; i++){	//board 값 받기
                for(int j=0; j<9; j++)board[i][j]=sc.nextInt();
            }
 
            int[] r = new int[9];	
            int[] c = new int[9];
            int[] s = new int[9];
 
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    r[i]|=(1<<(board[i][j]-1));	//<<가 먼데 |는 또 뭐고
                    c[j]|=(1<<(board[i][j]-1));
                    s[(i/3)*3+j/3]|=(1<<(board[i][j]-1));
                }
            }
            int res = (1<<9)-1;
            for(int i=0; i<9; i++){
                if((r[i]^res)>0 || (c[i]^res)>0 ||(s[i]^res)>0){
                    ans=0;break;
                }
            }
            System.out.printf("#%d %d\n",t,ans);
        }
    }
}
