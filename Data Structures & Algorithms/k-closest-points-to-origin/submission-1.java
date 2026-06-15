

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Min-Heap sorting by the 3rd element (squared distance) safely
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            // Skip Math.sqrt to avoid precision loss and save CPU cycles
            int squaredDistance = (x * x) + (y * y); 
            
            pq.add(new int[]{x, y, squaredDistance});
        }
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int[] arr = pq.poll();
            list.add(new int[]{arr[0], arr[1]});
        }
        
        return list.toArray(new int[0][]);
    }
}