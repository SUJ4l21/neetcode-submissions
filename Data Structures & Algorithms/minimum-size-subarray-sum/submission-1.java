class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int total = 0;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            total += nums[j];

            while (total >= target) {
                ans = Math.min(ans, j - i + 1);
                total -= nums[i];
                i++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}