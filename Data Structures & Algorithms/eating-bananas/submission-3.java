class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low =1,high=Integer.MIN_VALUE;
        for(int i : piles){
            high = Math.max(high,i);
        }
        int res =0;
        while(low<=high){
            int mid = low+(high-low)/2;

            if(caneat(mid,h,piles)){
                high = mid-1;
                res = mid;
            }else{
                low = mid+1;
            }
        }
        return res;
    }
    private boolean caneat(int k,int h,int[]piles){
        int time = 0;
        for(int i :piles){
            if(i<=k)time++;
            else {
                time+=(i+k-1)/k;
            }
        }
        return time<=h;
    }
}
