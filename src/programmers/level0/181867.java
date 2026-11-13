class Solution {
    public int[] solution(String myString) {
        char[] arr = myString.toCharArray();
        int count_x = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 'x'){
                count_x++;
            }
        }
        int[] answer = new int[count_x+1];
        int index = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 'x'){
                index++;
                continue;
            }
            answer[index]++;
            
        }
        return answer;
    }
}
