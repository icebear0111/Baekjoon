class Solution {
    public int[] solution(int n, int s) {
        if (n > s) { // 집합의 합보다 자연수의 개수가 많은 경우
            return new int[]{-1};
        }
        
        // 예제를 보면
        // 9 = {1, 8}, {2, 7}, {3, 6}, {4, 5} -> {4, 5}
        // 8 = {1, 7}, {2, 6}, {3, 5}, {4, 4} -> {4, 4}
        // 각 원소의 곱이 최대가 되는 집합 = 각 원소의 차이가 가장 작은 집합이다.
        // 따라서, s를 n으로 나눈 몫으로 배열의 모든 요소를 초기화하고
        // s를 n으로 나눈 나머지를 1씩 나누어 준다.
        
        int[] answer = new int[n];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = s / n;
        }
        
        for (int i = 0; i < s % n; i++) {
            answer[n - 1 - i]++; // 이렇게 하는 이유는, 집합의 요소를 오름차순으로 출력해야 하기 때문에, 배열의 마지막 요소부터 1을 더해준다.
        }
        
        return answer;
    }
}