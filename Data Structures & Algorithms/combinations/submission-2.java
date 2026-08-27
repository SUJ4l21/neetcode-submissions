class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        helper(1,n,k,list);
        return res;
    }
    private void helper(int i,int n,int k,List<Integer> list){

        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        if(i>n)return;

        list.add(i);
        helper(i+1,n,k,list);
        list.remove(list.size()-1);
        helper(i+1,n,k,list);

    }
}