class Solution {
    public int[] getConcatenation(int[] nums) {
        int [] arr = new int[nums.length*2];
        int n = nums.length;
        for(int i=0;i<n;i++){
            arr[i] = nums[i];
            arr[i+n]=nums[i];
        }
        return arr;
    }
}