package src.beakjoon.bronze;
import java.util.*;

class Q27918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int d = 0;
        int p = 0;
        for(int i = 0 ; i < N ; i++){
            String tmp = sc.next();
            if(tmp.equals("D")){
                d++;
            }else{
                p++;
            }
            
            if(Math.abs(d-p) == 2){
                break;
            }
        }
        System.out.println(d+":"+p);
    }
}
