class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=0;i<=n;i++){
            res[i]=check(i);
        }
        return res;
    }
    public int check(int x){
        if(x==0)return 0;
        int count=0;
        while(x>0){
            if(x%2==1)count++;
            x/=2;
        }
        return count;
    }
}
