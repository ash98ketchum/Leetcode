class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {

        int n = deck.length;
        Arrays.sort(deck);

        int[] ans = new int[n];
        List<Integer> lst = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            lst.add(i);
        }

        int idx = 0;  
        boolean skip = false;

        while(!lst.isEmpty()) {
            List<Integer> next = new ArrayList<>();
            for(int i = 0; i < lst.size(); i++) {
                if(!skip) {
                    ans[lst.get(i)] = deck[idx++];
                } else {
                    next.add(lst.get(i));
                }
                skip = !skip;
            }
            lst = next;
        }
        return ans;
    }
}
