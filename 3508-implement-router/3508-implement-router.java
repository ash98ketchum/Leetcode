class Packet{
    public int source;
    public int destination;
    public int timestamp;
    public long parse;
    public Packet next;
    public Packet prev;
    
    Packet( int s, int d, int t ,long p){
        source = s;
        destination = d;
        timestamp = t;
        next = null;
        prev = null;
        parse = p;
    }
}
class Router {
    private int capacity ; 
    Packet head;
    Packet tail;
    int size;
    Map<Long,Boolean> map;
    Map<Integer,ArrayList<Integer>> dest;
    
    
    public Router(int memoryLimit) {
        map = new HashMap<>();
        dest =new HashMap<>();
        size = 0;
        this.capacity = memoryLimit;
        head = new Packet(0,0,0,-1);
        tail = new Packet(0,0,0,-1);
        head.next = tail;
        tail.prev = head;
    }


    private void insertAtEnd(Packet packet){
        tail.prev.next = packet;
        packet.prev=tail.prev;
        packet.next = tail;
        tail.prev = packet;
    }
    private int lowerBound(ArrayList<Integer> list, int target) {
        int i = 0, j = list.size() - 1;
        int ans = list.size(); // default = end of list

        while (i <= j) {
            int mid = (i + j) / 2;
            int ele = list.get(mid); // O(n) in LinkedList

            if (ele >= target) {
                ans = mid;   // possible answer
                j = mid - 1; // look left for earlier occurrence
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }
    private int upperBound(ArrayList<Integer> list, int target){
        int i = 0, j = list.size() - 1;
        int ans = list.size(); // default = end of list

        while (i <= j) {
            int mid = (i + j) / 2;
            int ele = list.get(mid);

            if (ele > target) {
                ans = mid;   
                j = mid - 1; 
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }

    private long parseStr(int source, int destination, int timestamp) {
        return ((long) source << 40) | ((long) destination << 20) | timestamp;
    }


    
    public boolean addPacket(int source, int destination, int timestamp) {
        long key = parseStr(source, destination, timestamp);
        if(map.containsKey(key)){
            return false;
        }
        if (size >= capacity){
            Packet toRemove = head.next;
            map.remove(toRemove.parse);
            dest.get(toRemove.destination).removeFirst();
            head.next = toRemove.next;
            toRemove.next.prev = head;
            size--;

        }
        Packet packet = new Packet(source, destination, timestamp,key);
        map.put(key,true);
        
        insertAtEnd(packet);

        if( dest.containsKey(destination)){
            dest.get(destination).add(timestamp);
        }
        else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(timestamp);
            dest.put(destination,list);
        }
        size++;
        return true;
    }
    
    public int[] forwardPacket() {

        if (size == 0) return new int[0];

        Packet toRemove = head.next;
        int[] ans = {toRemove.source, toRemove.destination, toRemove.timestamp};

        // remove from maps
        map.remove(toRemove.parse);
        dest.get(toRemove.destination).remove(0);

        // unlink
        head.next = toRemove.next;
        toRemove.next.prev = head;
        size--;

        return ans;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        if (!dest.containsKey((destination))) return 0;
        int count = 0;
        ArrayList<Integer> list = dest.get(destination);
        int i = lowerBound(list,startTime);
        int j = upperBound(list,endTime);
        return j - i;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */