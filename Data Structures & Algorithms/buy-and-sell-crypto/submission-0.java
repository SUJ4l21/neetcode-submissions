class Solution {
    public int maxProfit(int[] nums) {
        int n=nums.length;
        int i =0,j=0;
        int profit =0;
        while(i<n && j<n){
            profit = Math.max(profit,(nums[j]-nums[i]));
            if(nums[i]>nums[j]){
                i++;
            }else{
                j++;
            }
        }
        return profit;
    }
}
