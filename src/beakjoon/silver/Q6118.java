package beakjoon.silver;

import java.util.*;

class Q6118 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        HashMap<Integer, ArrayList<Integer>> path = new HashMap<>();
        for(int m = 0 ; m < M ; m++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            
            if(!path.containsKey(A)){
                path.put(A, new ArrayList<Integer>());
            }
            if(!path.containsKey(B)){
                path.put(B, new ArrayList<Integer>());
            }
            
            ArrayList<Integer> shuttle_A = path.get(A);
            ArrayList<Integer> shuttle_B = path.get(B);
            
            shuttle_A.add(B);
            shuttle_B.add(A);
        }
        
        HashMap<Integer, Integer> length = new HashMap<>();
        length.put(1, 0);
        Queue<Integer> path_order = new LinkedList<>();
        path_order.add(1);
        
        while(!path_order.isEmpty()){
            int now = path_order.poll();
            int tmp_order = length.get(now);
            
            ArrayList<Integer> list = path.get(now);
            for(int next : list){
                if(!length.containsKey(next)){
                    length.put(next, tmp_order + 1);
                }else if(length.get(next) > tmp_order + 1){
                    length.replace(next, tmp_order + 1);
                }else{
                    continue;
                }
                path_order.add(next);
            }
        }
        
        int longist_length = 0;
        int shttle_number = 1;
        int same_length = 0;
        for(int num : length.keySet()){
            if(length.get(num) > longist_length){
                shttle_number = num;
                longist_length = length.get(num);
                same_length = 1;
            }else if(length.get(num) == longist_length){
                same_length++;
            }
        }
        
        System.out.printf("%d %d %d", shttle_number, longist_length, same_length );
    }
}