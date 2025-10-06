import java.util.*;
import java.io.*;

class Q14920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int cnt = 1;
        while(N > 1){
            cnt++;
            if(N % 2 == 0){
                N /= 2;
            }else{
                N = N * 3 + 1;
            }
        }
        
        System.out.print(cnt);
    }
}
