class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int x = (numer1 * denom2) + (numer2 * denom1);
        int y = denom1 * denom2;
        int gcd, x1, y1;
        
        x1 = x;
        y1 = y;
        while (y1 != 0) {
            int temp = y1;
            y1 = x1 % y1;
            x1 = temp;
        }
        gcd = x1;
        
        x = x / gcd;
        y = y / gcd;
        
        
        int[] answer = {x, y};
        return answer;
    }
}