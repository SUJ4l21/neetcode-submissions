class Solution {
    public boolean isAnagram(String s, String t) {
        int a = s.length();
        int b = t.length();
        if(a!=b)return false;
        Map<Character,Integer> n1 = new HashMap<>();
        Map<Character,Integer> n2 = new HashMap<>();
        for(char c : s.toCharArray()){
           n1.put(c , n1.getOrDefault(c,0)+1);
        }
        for(char c : t.toCharArray()){
           n2.put(c , n2.getOrDefault(c,0)+1);
        }
        if(n1.equals(n2))return true;
        return false;
    }
}
