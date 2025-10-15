package src.beakjoon.bronze;

import java.util.*;

class Q28074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mobis = "MOBIS";
        String str = sc.next();
        for(int i = 0 ; i < 5 ; i++){
            if(str.indexOf(mobis.charAt(i)) == -1){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
