class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(0,nums,target,list,res);
        return res;
    }
    public void helper(int i,int[] nums , int target,List<Integer> list, List<List<Integer>> res){
        if(i>=nums.length)return;
        if(target==0){
            res.add(new ArrayList<>(list));
        }
        if(nums[i]<=target){
            list.add(nums[i]);
            helper(i,nums,target-nums[i],list,res);
            list.remove(list.size() - 1);
            helper(i+1,nums,target,list,res);
        }
        return;
    }
}
