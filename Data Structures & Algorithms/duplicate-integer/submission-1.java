class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> map = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(!map.contains(nums[i])){
                map.add(nums[i]);
            }else{
                return true;
            }
        }
        return false;
    }
}