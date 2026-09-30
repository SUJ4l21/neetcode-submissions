class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums,0,list,res);
        return res;
    }
    public void dfs(int[] nums,int i,List<Integer> list,List<List<Integer>> res){
        if(i>=nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        list.add(nums[i]);
        dfs(nums,i+1,list,res);
        list.remove(list.size()-1);
        dfs(nums,i+1,list,res);
    }
}
