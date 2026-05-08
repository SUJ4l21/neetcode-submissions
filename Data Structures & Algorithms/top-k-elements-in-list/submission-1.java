class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
            
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(Map.Entry<Integer,Integer> hmap : map.entrySet()){
            int freq = hmap.getValue();
            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(hmap.getKey());
        }
        int []arr = new int[k];
        int i = nums.length;
        int j = 0;
        while(i >= 0 && j < k){
            if(bucket[i] != null) {
                for (int val : bucket[i]) {
                    if (j < k) arr[j++] = val;
                }
            }
            i--;
        }
        return arr;
    }
}