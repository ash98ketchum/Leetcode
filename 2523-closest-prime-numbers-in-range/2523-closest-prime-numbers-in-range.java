class Solution {
    static boolean sieve[] = new boolean[1000005];

    public static void sieveOfEratosthenes() {
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for (int i = 2; i*i < sieve.length; i++) {
            if (sieve[i]){
                for (int j = i * i; j < sieve.length; j += i) {
                    sieve[j] = false;
                }
            }
        }
    }
    public int[] closestPrimes(int left, int right) {
        sieveOfEratosthenes();
        ArrayList<Integer> primes=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(sieve[i]){
                primes.add(i);
            }
        }
        int res[]={-1,-1};
        int maxx=Integer.MAX_VALUE;
        for(int i=1;i<primes.size();i++){
            int diff=primes.get(i)-primes.get(i-1);
            if (diff < maxx) {
                maxx=diff;
                res[0]=primes.get(i-1);
                res[1]=primes.get(i);
            }
        }
        return res;
    }
}