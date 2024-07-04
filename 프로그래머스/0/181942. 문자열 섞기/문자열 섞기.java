class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        int cnt1 = 0;
        int cnt2 = 0;
    
        for (int i = 0; i < str1.length() + str2.length(); i++) {
            if (i % 2 == 0) {
                answer += str1.charAt(cnt1);
                cnt1++;
            }
            else {
                answer += str2.charAt(cnt2);
                cnt2++;
            }
        }
        
        return answer;
    }
}