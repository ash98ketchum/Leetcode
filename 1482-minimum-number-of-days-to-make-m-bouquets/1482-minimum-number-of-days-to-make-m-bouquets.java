class Solution {
    private static boolean mylove(int mid,int[] arr, int m, int k,int n){
        // boolean flower[]=new boolean[n];
        // for(int i=0;i<n;i++){
        //     if(arr[i]<=mid){
        //         flower[i]=true;
        //     }
        //     else{
        //         flower[i]=false;
        //     }
        // }
        int i=0;
        int tot=0;
        while(i<n){
            int cnt=0;
            while(i<n && arr[i]<=mid){
                cnt++;
                i++;
                if(cnt==k){
                    i--;
                    break;
                }
            }
            i++;
            if(cnt==k) tot++;
        }
        return tot>=m;
    }
    public int minDays(int[] arr, int m, int k) {
        int n=arr.length;
        if(m*k>n){
            return -1;
        }
        int start=Integer.MAX_VALUE;//search min val
        int end=Integer.MIN_VALUE;//search max val
        for(int it:arr){
            start=Math.min(it,start);
            end=Math.max(it,end);
        }

        int ilydivyanshi=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mylove(mid,arr,m,k,n)){
                ilydivyanshi=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ilydivyanshi;
        
    }
}