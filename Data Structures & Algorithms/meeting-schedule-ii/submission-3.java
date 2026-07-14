/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.isEmpty())return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        Collections.sort(intervals,(a,b)->a.start-b.start);
        pq.add(new int[]{intervals.get(0).start,intervals.get(0).end});
        for(Interval i : intervals){
            if(i==intervals.get(0))continue;
            int a = pq.peek()[0];
            int b = pq.peek()[1];
            if(b>i.start){
                pq.add(new int[]{i.start,i.end});
            }
            else {
                pq.poll();
                pq.add(new int[]{a,i.end});
            }
        }
        return pq.size();
    }
}