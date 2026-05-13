class Solution {
    public int trap(int[] nums) {
        int n = nums.length;
        int water = 0;
        int prefix[] = new int[n];
        prefix[0]=nums[0];
        int suffix[] = new int[n];
        suffix[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            prefix[i]=Math.max(prefix[i-1],nums[i]);
        }
        for(int i=n-2;i>=0;i--){
            suffix[i]=Math.max(suffix[i+1],nums[i]);
        }
        for(int i=0;i<n;i++){
            water+= Math.min(prefix[i],suffix[i])-nums[i];
        }
        return water;
    }
}
