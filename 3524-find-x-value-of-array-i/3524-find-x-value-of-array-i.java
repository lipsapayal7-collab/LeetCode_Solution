class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] dp=new long[k];
        long[] ans=new long[k];
        for(int x:nums){
            long[] ndp=new long[k];
            int v=x%k;
            ndp[v]=1;
            for(int r=0;r<k;r++){
                int nr=(r*v)%k;
                ndp[nr]+=dp[r];
            }
            for(int r=0;r<k;r++)
                ans[r]+=ndp[r];
            dp=ndp;
        }
        return ans;
    }
}