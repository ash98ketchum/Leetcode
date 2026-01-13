class Solution {
    private double helper(int[][] squares, double y) {
        double area = 0;
        for (int[] square : squares) {
            double yi = square[1];
            double li = square[2];
            if (y <= yi) {
                area += li * li;
            }
            else if (y < yi + li) {
                area += li * (yi + li - y);
            }
        }
        return area;
    }
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        for (int[] square : squares) {
            double li = square[2];
            totalArea += li * li;
        }
        double target = totalArea / 2.0;
        double start = 0.0,end =1e13*1.0;
        double iter = 1e-5;
        while (end -start> iter) {
            double mid =start+(end-start)/ 2.0;
            if(helper(squares, mid)>target) {
                start= mid;
            } else {
                end= mid;
            }
        }
        return start;
    }
}