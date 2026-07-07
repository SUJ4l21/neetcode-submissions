class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> adj = new HashMap<>();
        for(List<String> ticket : tickets){
            adj.putIfAbsent(ticket.get(0),new ArrayList<>());
        }
        tickets.sort((a,b)-> a.get(1).compareTo(b.get(1)));
        for(List<String> ticket : tickets){
            adj.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");
        if(dfs("JFK",adj,res,tickets.size()+1))return res;
        return new ArrayList<>();
    }
    public boolean dfs(String src,Map<String,List<String>> adj,List<String> res,int target ){
        if (res.size()==target)return true;
        if(!adj.containsKey(src))return false;
        List<String> temp = new ArrayList<>(adj.get(src));
        for(int i=0;i<temp.size();i++){
            String node = temp.get(i);
            adj.get(src).remove(i);
            res.add(node);
            if(dfs(node,adj,res,target))return true;
            adj.get(src).add(i,node);
            res.remove(res.size()-1);
        }
        return false;
    }
}
