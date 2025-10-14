package src.beakjoon.bronze;

import java.util.*;

// The main method must be in a class named "Main".
class Q17293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int N = sc.nextInt();
        int ori = N;
        while(N >= 0){
            if(N > 2){
                sb.append(N);
                sb.append(" bottles of beer on the wall, ");
                sb.append(N--);
                sb.append(" bottles of beer.\nTake one down and pass it around, ");
                sb.append(N);
                sb.append(" bottles of beer on the wall.");
            }else if(N == 2){
                sb.append(N);
                sb.append(" bottles of beer on the wall, ");
                sb.append(N--);
                sb.append(" bottles of beer.\nTake one down and pass it around, ");
                sb.append(N);
                sb.append(" bottle of beer on the wall.");
            }else if(N == 1){
                sb.append(N);
                sb.append(" bottle of beer on the wall, ");
                sb.append(N--);
                sb.append(" bottle of beer.\nTake one down and pass it around, ");
                sb.append("no more bottles of beer on the wall.");
            }else if(N == 0){
                sb.append("No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, ");
                if(ori == 1){
                    sb.append(ori+" bottle");
                }else{
                    sb.append(ori+" bottles");
                }
                sb.append(" of beer on the wall.");
                break;
            }
            sb.append("\n\n");
        }

        System.out.print(sb.toString());
    }
}
