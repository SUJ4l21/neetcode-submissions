class Solution {
    public int maxArea(int[]nums) {
        int max =0;
        int i =0;
        int j=nums.length-1;
        while(i!=j){
            int diff = j-i;
            max = Math.max(max , (Math.min(nums[i],nums[j])*diff));
            if(nums[i]<=nums[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}
