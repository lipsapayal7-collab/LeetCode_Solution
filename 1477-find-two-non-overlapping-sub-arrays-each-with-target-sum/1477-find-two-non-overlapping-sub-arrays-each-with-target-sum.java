class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length,ans=n+1,sum=0,min=n+1;
        int best[]=new int[n];
        Arrays.fill(best,n+1);
        HashMap<Integer,Integer> m=new HashMap<>();
        m.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            best[i]=i>0?best[i-1]:n+1;
            if(m.containsKey(sum-target)){
                int j=m.get(sum-target);
                int len=i-j;
                if(j>=0&&best[j]<n+1)
                    ans=Math.min(ans,len+best[j]);
                min=Math.min(min,len);
                best[i]=Math.min(best[i],min);
            }
            m.put(sum,i);
        }
        return ans>n?-1:ans;
    }
}