class Solution {
    public int distinctSubseqII(String s) {
        int mod=1000000007;
        long[] dp=new long[s.length()+1];
        dp[0]=1;
        int[] last=new int[26];
        for(int i=1;i<=s.length();i++){
            int x=s.charAt(i-1)-'a';
            dp[i]=(2*dp[i-1])%mod;
            if(last[x]>0)
                dp[i]=(dp[i]-dp[last[x]-1]+mod)%mod;
            last[x]=i;
        }
        return (int)(dp[s.length()]-1+mod)%mod;
    }
}