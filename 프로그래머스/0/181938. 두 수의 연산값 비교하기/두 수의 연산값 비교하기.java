class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String answer1 = Integer.toString(a) + Integer.toString(b);
        int answer2 = 2 * a * b;
        
        if (Integer.parseInt(answer1) > answer2)
            answer = Integer.parseInt(answer1);
        else
            answer = answer2;
        
        return answer;
    }
}