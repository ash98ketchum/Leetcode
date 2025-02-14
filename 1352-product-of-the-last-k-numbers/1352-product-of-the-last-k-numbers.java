class ProductOfNumbers {
    private ArrayList<Integer> arr;
    public ProductOfNumbers() {
        arr=new ArrayList<>();
        arr.add(1);
    }
    
    public void add(int num) {
        arr.add(num);
    }
    
    public int getProduct(int k) {
        int prod=1;
        for(int i=arr.size()-1;i>=arr.size()-k;i--){
            prod*=arr.get(i);
        }
        return prod;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */