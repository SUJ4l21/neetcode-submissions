class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][0] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }
        list.add(newInterval);
        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }
        // Merge intervals
        List<int[]> merged = new ArrayList<>();
        for (int[] curr : list) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < curr[0]) {
                merged.add(curr);
            } else {
                merged.get(merged.size() - 1)[1] =
                        Math.max(merged.get(merged.size() - 1)[1], curr[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}