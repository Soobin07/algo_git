package codeup;
import java.util.Scanner;

public class C1257 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        for(int i = start ; i <= end ; i++){
            if(i%2 == 1){
                System.out.print(i+" ");
            }
        }
    }
}
