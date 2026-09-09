class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int x = Math.min(word1.length(),word2.length());
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<x;i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if(word1.length()<word2.length()){
            for(int i=x;i<word2.length();i++){
                sb.append(word2.charAt(i));
            }
        }else{
            for(int i=x;i<word1.length();i++){
                sb.append(word1.charAt(i));
            }
        }
        return sb.toString();
    }
}