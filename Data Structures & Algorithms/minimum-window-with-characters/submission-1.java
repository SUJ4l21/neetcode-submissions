class Solution {
    public String minWindow(String s, String t) {
        if(t.length()<1)return "";
        Map<Character,Integer> count = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(char c : t.toCharArray()){
            count.put(c,count.getOrDefault(c,0)+1);
        }
        int l =0;
        int [] res = {-1,-1};
        int reslen = Integer.MAX_VALUE;
        int have =0,need = count.size();

        for(int r =0 ; r<s.length();r++){
            char c = s.charAt(r);
            window.put(c,window.getOrDefault(c,0)+1);

            if(count.containsKey(c) && window.get(c).equals(count.get(c))){
                have++;
            }

            while(have == need){
                if((r-l+1)<reslen){
                    reslen = r-l+1;
                    res[0]=l;
                    res[1]=r;
                }

                char ch = s.charAt(l);
                window.put(ch,window.get(ch)-1);
                if(count.containsKey(ch) && window.get(ch) < count.get(ch)){
                    have--;
                }
                l++;
            }
        }
        return reslen == Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);
    }
}
