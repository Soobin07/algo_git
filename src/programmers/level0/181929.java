class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum = 0;
        int mult = 1;
        
        for(int i = 0 ; i < num_list.length ; i++){
            sum += num_list[i];
            mult *= num_list[i]; 
        }
        
        answer = Math.pow(sum, 2) > mult ? 1 : 0;
        
        return answer;
    }
}
