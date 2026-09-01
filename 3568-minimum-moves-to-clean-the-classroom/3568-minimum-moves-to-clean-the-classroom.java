import java.util.*;
class Solution {
    public int minMoves(String[] classroom,int energy) {
        int m=classroom.length,n=classroom[0].length();
        int sr=0,sc=0,k=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                char ch=classroom[i].charAt(j);
                if(ch=='S'){sr=i;sc=j;}
                if(ch=='L') k++;
            }
        int[][] id=new int[m][n];
        for(int[] a:id) Arrays.fill(a,-1);
        int x=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(classroom[i].charAt(j)=='L')
                    id[i][j]=x++;
        boolean[][][][] vis=new boolean[m][n][energy+1][1<<k];
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{sr,sc,energy,0,0});
        vis[sr][sc][energy][0]=true;
        int[] dr={1,-1,0,0};
        int[] dc={0,0,1,-1};
        int full=(1<<k)-1;
        while(!q.isEmpty()){
            int[] a=q.poll();
            int r=a[0],c=a[1],e=a[2],mask=a[3],d=a[4];
            if(mask==full) return d;
            if(e==0) continue;
            for(int z=0;z<4;z++){
                int nr=r+dr[z],nc=c+dc[z];
                if(nr<0||nr>=m||nc<0||nc>=n||
                   classroom[nr].charAt(nc)=='X') continue;
                int ne=e-1,nm=mask;
                char ch=classroom[nr].charAt(nc);
                if(ch=='R') ne=energy;
                if(ch=='L') nm|=1<<id[nr][nc];
                if(!vis[nr][nc][ne][nm]){
                    vis[nr][nc][ne][nm]=true;
                    q.add(new int[]{nr,nc,ne,nm,d+1});
                }
            }
        }
        return -1;
    }
}