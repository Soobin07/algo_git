class Solution {
    public int solution(int a, int b) {
        int answer = Integer.parseInt(a+""+b);
        answer = answer < 2 * a * b ? 2 * a * b : answer;
        return answer;
    }
}
