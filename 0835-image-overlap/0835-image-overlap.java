class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
    int n=img1.length,ans=0;
        for(int x=-(n-1);x<n;x++){
            for(int y=-(n-1);y<n;y++){
                int c=0;
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        int a=i+x,b=j+y;
                        if(a>=0&&a<n&&b>=0&&b<n&&img1[i][j]==1&&img2[a][b]==1)
                            c++;
                    }
                }
                ans=Math.max(ans,c);
            }
        }
        return ans;
    }
}