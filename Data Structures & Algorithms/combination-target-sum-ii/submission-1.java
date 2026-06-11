class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(0,nums,target,list,res);
        return res;
    }
    public void helper(int i,int[]nums,int target,List<Integer>list , List<List<Integer>> res){
        
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int x =i;x<nums.length;x++){
            if(nums[x]>target)break;

            if(x>i && nums[x]==nums[x-1])continue;

            list.add(nums[x]);
            helper(x+1,nums,target-nums[x],list,res);
            list.remove(list.size()-1);
            
        }
        
    }
}
