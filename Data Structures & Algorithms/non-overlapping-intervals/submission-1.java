class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res=0;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int prev=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int end= intervals[i][1];
            int start= intervals[i][0];
            if(prev<=start){
                prev=end;
            }else{
                res++;
                prev  = Math.min(prev,end);
            }
        }
        return res;
    }
}
