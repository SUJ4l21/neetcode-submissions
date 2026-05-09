class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[]pre = new int[nums.length];
        int[]suf = new int[nums.length];
        int res[]=new int[nums.length];
        //pre[0]=1;
        //suf[nums.length-1]=1;
        int j =1;
        for(int i=0;i<nums.length;i++){
            pre[i]=j;
            j*=nums[i];
        }
        j=1;
        for(int i=nums.length-1;i>=0;i--){
            suf[i]=j;
            j*=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            res[i]=pre[i]*suf[i];
        }
        return res;
    }
}  
