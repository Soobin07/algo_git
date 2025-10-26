package src.beakjoon.bronze;

import java.util.*;

class Q10173 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String now = sc.nextLine();
        while(!now.equals("EOI")){
            now = now.toUpperCase();
            if(now.contains("NEMO")){
                System.out.println("Found");
            }else{
                System.out.println("Missing");
            }
            now = sc.nextLine();
        }
    }
}
