package src.beakjoon.silver;

import java.util.*;

class Q15658 {
    static int[] numbers;
    static long max, min;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers= new int[N];
        for(int i = 0 ; i < N ; i++){
            numbers[i] = sc.nextInt();
        }
        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int mult = sc.nextInt();
        int divi = sc.nextInt();
        
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
        
        play(1, numbers[0], plus, minus, mult, divi);
        
        System.out.println(max);
        System.out.println(min);
    }
    
    static void play(int index, int sum, int plus, int minus, int mult, int divi){
        if(index == N){
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }
        //plus
        if(plus > 0)
            play(index+1, sum+numbers[index], plus-1, minus, mult, divi);
        //minus
        if(minus > 0)
            play(index+1, sum-numbers[index], plus, minus-1, mult, divi);
        //mult
        if(mult > 0)
            play(index+1, sum*numbers[index], plus, minus, mult-1, divi);
        //divi
        if(divi > 0)
            play(index+1, sum/numbers[index], plus, minus, mult, divi-1);
    }
}
