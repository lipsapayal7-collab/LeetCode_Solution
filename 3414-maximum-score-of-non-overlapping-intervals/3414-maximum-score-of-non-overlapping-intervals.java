class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n=intervals.size();
        int[][] a=new int[n][4];
        for(int i=0;i<n;i++){
            a[i][0]=intervals.get(i).get(0);
            a[i][1]=intervals.get(i).get(1);
            a[i][2]=intervals.get(i).get(2);
            a[i][3]=i;
        }
        Arrays.sort(a,(x,y)->x[1]-y[1]);
        long[][] dp=new long[n+1][5];
        ArrayList<Integer>[][] path=new ArrayList[n+1][5];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=4;j++){
                path[i][j]=new ArrayList<>();
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=4;j++){
                dp[i][j]=dp[i-1][j];
                path[i][j]=new ArrayList<>(path[i-1][j]);
            }
            int left=a[i-1][0];
            int l=0;
            int r=i-1;
            while(l<r){
                int mid=(l+r+1)/2;
                if(a[mid-1][1]<left)
                    l=mid;
                else
                    r=mid-1;
            }
            int p=l;
            for(int j=1;j<=4;j++){
                long score=dp[p][j-1]+a[i-1][2];
                ArrayList<Integer> cur=
                    new ArrayList<>(path[p][j-1]);
                cur.add(a[i-1][3]);
                Collections.sort(cur);
                if(score>dp[i][j]||
                  (score==dp[i][j]&&less(cur,path[i][j]))){
                    dp[i][j]=score;
                    path[i][j]=cur;
                }
            }
        }
        ArrayList<Integer> best=new ArrayList<>();
        for(int j=0;j<=4;j++){
            if(dp[n][j]>dp[n][best.size()]||
              (dp[n][j]==dp[n][best.size()]
              &&less(path[n][j],best))){
                best=new ArrayList<>(path[n][j]);
            }
        }
        Collections.sort(best);
        return best.stream().mapToInt(x->x).toArray();
    }
    boolean less(ArrayList<Integer> a,ArrayList<Integer> b){
        int n=Math.min(a.size(),b.size());
        for(int i=0;i<n;i++){
            if(!a.get(i).equals(b.get(i)))
                return a.get(i)<b.get(i);
        }
        return a.size()<b.size();
    }
}