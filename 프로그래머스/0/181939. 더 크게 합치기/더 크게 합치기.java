class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String answer1 = Integer.toString(a) + Integer.toString(b);
        String answer2 = Integer.toString(b) + Integer.toString(a);
        if (Integer.parseInt(answer1) > Integer.parseInt(answer2))
            answer = Integer.parseInt(answer1);
        else
            answer = Integer.parseInt(answer2);
        return answer;
    }
}