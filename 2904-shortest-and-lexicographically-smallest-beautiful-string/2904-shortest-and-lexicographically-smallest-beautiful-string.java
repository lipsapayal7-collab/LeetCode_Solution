class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int p[]=new int[n];
        int c=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                p[c++]=i;
            }
        }
        if(c<k){
            return "";
        }
        int m=Integer.MAX_VALUE;
        String a="";
        for(int i=0;i<=c-k;i++){
            int st=p[i];
            int e=p[i+k-1];
            int l=e-st+1;
            String cur=s.substring(st,e+1);
            if(l<m){
                m=l;a=cur;
            }
            else if(l==m && cur.compareTo(a)<0) a=cur;
        }
        return a;
    }
}