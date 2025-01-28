import java.util.PriorityQueue;
class MedianFinder {
    private PriorityQueue<Integer> mxx;
    private PriorityQueue<Integer> mnn;
    public MedianFinder() {
        mxx= new PriorityQueue<>((a, b) -> b - a);
        mnn= new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        mxx.offer(num);
        mnn.offer(mxx.poll());
        if (mxx.size() < mnn.size()) {
            mxx.offer(mnn.poll());
        }
    }
    
    public double findMedian() {
        if (mxx.size() == mnn.size()) {
            return (mxx.peek() + mnn.peek()) / 2.0;
        } else {
            return mxx.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */