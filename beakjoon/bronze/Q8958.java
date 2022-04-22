package beakjoon.bronze;

import java.util.Scanner;

public class Q8958 {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int count = sc.nextInt();
        String[] scores = new String[count];
        
        for(int i = 0 ; i < count ; i++){
            scores[i] = sc.next();
        }
        
        for(int i = 0 ; i < scores.length ; i++){
            int cont = 0;
            int score = 0;
            
            for(int j = 0 ; j < scores[i].length() ; j++){
                if(scores[i].charAt(j) == 'O') {
                    cont+=1;
                    score+=cont;
                }else{
                    cont = 0;
                }
            }
            
            System.out.println(score);
        }
    }
}
