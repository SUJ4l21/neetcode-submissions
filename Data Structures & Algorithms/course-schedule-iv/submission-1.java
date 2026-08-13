class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int [] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        List<Set<Integer>> pre = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            pre.add(new HashSet<>());
        }
        for(int [] i : prerequisites){
            adj.get(i[0]).add(i[1]);
            indegree[i[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.add(i);
        }

        while(!q.isEmpty()){
            int u = q.poll();
            for(int i : adj.get(u)){

                pre.get(i).add(u);
                pre.get(i).addAll(pre.get(u));

                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }


        List<Boolean> res = new ArrayList<>();
        for(int []arr : queries){
            
            res.add(pre.get(arr[1]).contains(arr[0]));
        }
        return res;
    }
}