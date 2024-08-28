import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int year = Integer.parseInt(today.substring(0,4));
        int month = Integer.parseInt(today.substring(5,7));
        int day = Integer.parseInt(today.substring(8,10));
        int totalDay = (year * 12 * 28) + (month * 28) + day; // 오늘 날짜를 일로 계산하여 저장
        
        ArrayList<Integer> answerArr = new ArrayList<>(); // 파기할 개인정보의 번호를 저장할 리스트
        HashMap<Character, Integer> map = new HashMap<>(); // 각각의 약관 종류와 유효기간을 짝 지어서 저장
        for (String str : terms) {
            map.put(str.charAt(0), Integer.parseInt(str.substring(2)));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            char privacyTerm = privacies[i].charAt(11); // 개인정보의 약관 종류
            int privacyYear = Integer.parseInt(privacies[i].substring(0,4));
            int privacyMonth = Integer.parseInt(privacies[i].substring(5,7));
            int privacyDay = Integer.parseInt(privacies[i].substring(8,10));
            int totalPrivacyDay = (privacyYear * 12 * 28) + (privacyMonth * 28) + privacyDay; // 개인정보의 수집일자를 일로 계산
            
            int termExpire = map.get(privacyTerm);
            int termPeriod = termExpire * 28;
            if (totalPrivacyDay + termPeriod <= totalDay) { // 수집일자와 약관의 유효기간을 더하여 오늘 날짜와 비교
                answerArr.add(i + 1);
            }
        }
        
        int[] answer = new int[answerArr.size()]; // 파기할 개인정보 리스트를 정수 배열에 저장
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerArr.get(i);
        }
        
        return answer;
    }
}