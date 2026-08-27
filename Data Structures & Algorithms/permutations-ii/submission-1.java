class Solution {
    Set<List<Integer>> res ;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        boolean [] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums,list,used);
        return new ArrayList<>(res);
    }
    private void helper(int[]nums,List<Integer> list,boolean[] used){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            if(i>0  && nums[i]==nums[i-1] && !used[i - 1]) continue;
            used[i]=true;
            list.add(nums[i]);
            helper(nums,list,used);
            list.remove(list.size()-1);
            used[i]=false;
            
        }
    }
}