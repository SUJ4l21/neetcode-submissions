class Solution {
    public int searchInsert(int[] nums, int target) {
        int i =0;
        int j = nums.length-1;
        int index = 0;
        while(i<=j){

            int mid = i +(j-i)/2;

            if(nums[mid]<target){
                index = mid+1;
                i = mid+1;
            }else if(nums[mid]>target){
                index = mid;
                j = mid-1;
            }else{
                return mid;
            }

        }
        return index;
    }
}