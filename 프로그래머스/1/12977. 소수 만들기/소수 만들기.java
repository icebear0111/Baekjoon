class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int flag = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    for (int x = 2; x < sum; x++) {
                        if (sum % x == 0)
                            flag = 1;
                    }
                    if (flag == 0)
                        answer += 1;
                    flag = 0;
                }
            }
        }

        return answer;
    }
}