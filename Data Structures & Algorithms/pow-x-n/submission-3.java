class Solution {
    public double myPow(double x, int n) {
        if (n==0) return 1.00000;
        double a = x;
        for(int i=1;i<Math.abs(n);i++){
            x*=a;
        }
        return n>=0?x:1/x;
        //return x;
    }
}
