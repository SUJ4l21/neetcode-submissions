class Solution {
    List<List<Integer>>res ;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        helper(new ArrayList<>(),nums, new boolean[nums.length]);
        return res;
    }
    public void helper(List<Integer> list , int [] nums , boolean[] flag){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!flag[i]){
                list.add(nums[i]);
                flag[i]=true;
                helper(list,nums,flag);
                list.remove(list.size()-1);
                flag[i]=false;
            }
        }
    }
}
