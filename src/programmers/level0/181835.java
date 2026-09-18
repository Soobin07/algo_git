class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[arr.length];
        boolean odd = k % 2 == 0 ? false : true;
        if(odd){
            for(int i = 0 ; i < arr.length ; i++){
                answer[i] = arr[i] * k;
            }
        }else{
            for(int i = 0 ; i < arr.length ; i++){
                answer[i] = arr[i] + k;
            }
        }
        
        return answer;
    }
}
