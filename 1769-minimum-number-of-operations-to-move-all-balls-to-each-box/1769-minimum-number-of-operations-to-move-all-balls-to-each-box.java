class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int res[]=new int[n];
        int sum=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)=='1'){
                sum+=i;
                cnt++;
            }
        }
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)!='1'){
                res[i]=sum-(cnt*i);
            }
            else{
                sum-=i;
                cnt--;
                res[i]=sum-(cnt*i);
            }
        }
        StringBuilder sb = new StringBuilder(boxes);
        boxes = sb.reverse().toString();
        int sum2=0;
        int cnt2=0;
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)=='1'){
                sum2+=i;
                cnt2++;
            }
        }
        int res2[]=new int[n];
        
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)!='1'){
                res2[i]=sum2-(cnt2*i);
            }
            else{
                sum2-=i;
                cnt2--;
                res2[i]=sum2-(cnt2*i);
            }
        }
        int i=0;
        int j=n-1;
        while(i<n && j>=0){
            res[i]=res[i]+res2[j];
            i++;
            j--;
        }
        return res;
    }
}