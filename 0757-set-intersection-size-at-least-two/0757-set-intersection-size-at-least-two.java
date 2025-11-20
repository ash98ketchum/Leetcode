class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        int cnt = 0;
        int a = -2, b = -1;
        for(int it[] : intervals){
            int si = it[0];
            int ei = it[1];

            if(si > b){
                cnt += 2;
                b = ei;
                a = ei - 1;
            }
            else if(si > a){
                cnt++;
                a = b;
                b = ei;
            }
        }
        return cnt;
    }
}