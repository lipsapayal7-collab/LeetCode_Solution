class Solution {
    public boolean checkDivisibility(int n) {
        int t=n;
        int s=0;
        int p=1;
        while(t>0){
            int d=t%10;
            s+=d;
            p*=d;
            t/=10;
        }
        int total=s+p;
        return n%total==0;
    }
}