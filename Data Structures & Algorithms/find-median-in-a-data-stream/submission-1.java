class MedianFinder {
    PriorityQueue<Integer>small;
    PriorityQueue<Integer>large;
    public MedianFinder() {
        small = new PriorityQueue<>((a,b)-> b-a);
        large = new PriorityQueue<>((a,b)-> a-b);
    }
    
    public void addNum(int num) {
        if(!large.isEmpty() && num > large.peek()){
            large.add(num);
        }
        else{
            small.add(num);
        }
        if(large.size()-small.size()>1){
            small.add(large.poll());
        }else if(small.size()-large.size()>1){
            large.add(small.poll());
        }
    }
    
    public double findMedian() {
        if(large.size()>small.size()){
            return ((double)large.peek());
        }else if(large.size()<small.size()){
            return ((double)small.peek());
        }else{
            return (double)(large.peek()+small.peek())/2;
        }
    }
}
