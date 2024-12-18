class LeetCode_Q_No1475 {
    public int[] finalPrices(int[] arr) {
        int []ans=new int[arr.length];
        int j=0;
        int f=0;
        for(int i=0;i<arr.length-1;i++){
            j=i+1;
            f=0;
            while(arr[i]<arr[j]){
                if(j==arr.length-1){
                    ans[i]=arr[i];
                    f=1;
                    break;
                }
                j++;
            }
            if(f==0)ans[i]=arr[i]-arr[j];
        }
        ans[arr.length-1]=arr[arr.length-1];
        return ans;
    }
}
