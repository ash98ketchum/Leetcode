class Solution {
    public static boolean ispalindrome(String s){
        int n=s.length();
        int i=0;
        while(i<n){
            if(s.charAt(i)!=s.charAt(n-i-1)){
                return false;
            }
            i++;
        }
        return true;
    }
    public static void myrec(List<List<String>> res,List<String> temp,int n,int idx,String s){
        //base condition
        if(idx==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        //recursive calls
        String s2="";
        for(int i=idx;i<n;i++){
            s2+=s.charAt(i);
            if(ispalindrome(s2)){
                temp.add(s2);
                myrec(res,temp,n,i+1,s);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();

        int n=s.length();
        myrec(res,temp,n,0,s);
        return res;
    }
}