class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(0,list , nums , res);
        return res;
    }
    public void helper(int i ,List<Integer>list , int [] nums , List<List<Integer>> res){
        if(i>=nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        helper(i+1,list,nums,res);
        list.remove(list.size()-1);
        while(i+1 <nums.length && nums[i]==nums[i+1]){
            i++;
        } 
        helper(i+1,list,nums,res);
    }
}
