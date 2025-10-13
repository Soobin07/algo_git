package src.backjoon.bronze;

import java.util.*;

class Q1871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        for(int n = 0 ; n < N ; n++){
            String[] str = sc.next().split("-");
            String ABC = str[0];
            int ABC_num = 0;
            for(int i = 0 ; i < 3 ; i++){
                ABC_num += ((ABC.charAt(i) - 'A')*Math.pow(26, 2-i));
            }
            int num = Integer.parseInt(str[1]);
    
            if(Math.abs(ABC_num - num) <= 100){
                sb.append("nice");
            }else{
                sb.append("not nice");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
