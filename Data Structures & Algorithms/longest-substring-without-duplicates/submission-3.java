class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char [] c = s.toCharArray();
        int n = s.length();
        int max =0;
        int l=0;
        for(int r =0;r<n;r++){
            while(set.contains(c[r])){
                set.remove(c[l]);
                l++;
            }
            set.add(c[r]);
            max = Math.max(max , (r-l +1));
        }
        
        return max;
    }
}
