class Solution {
    boolean res = false;
    public boolean search(int[] nums, int target) {
        int pivot =0;
        int n = nums.length;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                pivot =i;
                break;
            }
        }

        int start = 0;
        int end = pivot;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                res = true;
                break;
            }
            else if(nums[mid]<target) start = mid+1;
            else end = mid -1;
        }
        start = pivot+1;
        end = n-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                res = true;
                break;
            }
            else if(nums[mid]<target) start = mid+1;
            else end = mid -1;
        }

        return res;
        
    }

}