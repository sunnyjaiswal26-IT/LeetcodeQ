class LeetCode_Q_No769 {
    static int help(int[]arr,int minidx,int maxidx){
        int i=0;
        for(int x=arr.length-1;x>minidx;x--){
            if(arr[x]<=arr[maxidx]){
                minidx=x;
                i=1;
                break;
            }
        }
        if(i==1){
            for(int p=maxidx;p<=minidx;p++){
                if(arr[maxidx]<arr[p])maxidx=p;
            }
            minidx= help(arr,minidx,maxidx);
            return minidx;
        }

        return minidx;
    }
    static int smallestnoidx(int []arr,int i){
        int minidx=i;
        int maxidx=i;
        for(int j=i;j<arr.length;j++){
            if(arr[minidx]>arr[j])minidx=j;

        }
        for(int p=i;p<=minidx;p++){
            if(arr[maxidx]<arr[p])maxidx=p;
        }
        minidx= help(arr,minidx,maxidx);

        return minidx;
    }
    public int maxChunksToSorted(int[] arr) {
        int ans=0;
        int i=0;
        while(i<arr.length){
            i=smallestnoidx(arr,i);
            ans++;
            i++;
        }
        return ans;
    }
}