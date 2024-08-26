import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<> ();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        
        int[] index = new int[friends.length]; // 선물 지수
        int[][] record = new int[friends.length][friends.length]; // 주고 받은 선물 기록표
        
        for (String str : gifts) {
            String[] name = str.split(" ");
            index[map.get(name[0])]++; // 선물을 준 경우 선물 지수 +1
            index[map.get(name[1])]--; // 받은 경우 선물 지수 -1
            record[map.get(name[0])][map.get(name[1])]++;
        }
        
        int answer = 0;
        
        for (int i = 0; i < friends.length; i++) {
            int cnt = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                if (record[i][j] > record[j][i]) cnt++; // i가 j에게 선물을 더 많이 줬다면 선물을 받는다
                if (record[i][j] == record[j][i] && index[i] > index[j]) cnt++; // i랑 j가 주고 받은 선물 개수가 같은 경우 i의 선물 지수가 더 높으면 선물을 받는다
            }
            if (cnt > answer) answer = cnt;
        }
        return answer;
    }
}