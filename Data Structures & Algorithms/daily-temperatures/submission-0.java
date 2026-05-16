class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> s = new Stack<>();
        int []res = new int[temperatures.length];
        for(int i =0;i<temperatures.length;i++){
            int t = temperatures[i];
            while(!s.isEmpty() && t > s.peek()[0]){
                int []pair = s.pop();
                res[pair[1]]= i - pair[1];
            }
            s.push(new int[]{t,i});
        }
        return res;
    }
}
