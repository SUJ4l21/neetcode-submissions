class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character,Set<Character>> adj = new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();

        for(String word : words){
            for(char c : word.toCharArray()){
                adj.putIfAbsent(c,new HashSet<>());
                indegree.putIfAbsent(c,0);
            }
        }

        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];

            if(w1.length()>w2.length() && w1.startsWith(w2))return "";
            int minlen = Math.min(w1.length(),w2.length());
            for(int j=0;j<minlen;j++){
                char a = w1.charAt(j);
                char b = w2.charAt(j);
                if(a!=b){
                    if(!adj.get(a).contains(b)){
                        adj.get(a).add(b);
                        indegree.put(b,indegree.get(b)+1);
                    }
                    break;
                }
            }
        }

            Queue<Character> q = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for(char c : indegree.keySet()){
                if(indegree.get(c)==0)q.add(c);
            }

            while(!q.isEmpty()){
                char c = q.poll();
                sb.append(c);
                for(char ch : adj.get(c)){
                    indegree.put(ch,indegree.get(ch)-1);

                    if(indegree.get(ch)==0)q.add(ch);
                }
            }

            if(sb.length()!=indegree.size())return "";
            return sb.toString();
        
    }
}
