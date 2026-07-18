class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // The HashSet now stores the INDEX of the visited point, not the array
        HashSet<Integer> visited = new HashSet<>();
        
        // pq stores: {weight, point_index}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // Start from the first point (index 0) with a weight of 0
        pq.add(new int[]{0, 0});
        
        int sum = 0;
        
        // Stop early if we have connected all points
        while (!pq.isEmpty() && visited.size() < n) {
            int[] current = pq.poll();
            int weight = current[0];
            int nodeIndex = current[1];
            
            // If we've already visited this exact node index, skip it
            if (visited.contains(nodeIndex)) {
                continue;
            }
            
            // Mark the node as visited and add to the total cost
            visited.add(nodeIndex);
            sum += weight;
            
            // Calculate distances to all unvisited points and add to queue
            for (int nextNodeIndex = 0; nextNodeIndex < n; nextNodeIndex++) {
                if (!visited.contains(nextNodeIndex)) {
                    int dist = Math.abs(points[nodeIndex][0] - points[nextNodeIndex][0]) + 
                               Math.abs(points[nodeIndex][1] - points[nextNodeIndex][1]);
                    pq.add(new int[]{dist, nextNodeIndex});
                }
            }
        }
        
        return sum;
    }
}