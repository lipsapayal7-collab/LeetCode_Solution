class Solution {
    public int stoneGameVIII(int[] stones) {
        int n=stones.length;
        int p[]=new int[n];
        p[0]=stones[0];
        for(int i=1;i<n;i++){
            p[i]=p[i-1]+stones[i];
        }
        int b=p[n-1];
        for(int i=n-2;i>=1;i--){
            b=Math.max(b,p[i]-b);
        }
        return b;
    }
}