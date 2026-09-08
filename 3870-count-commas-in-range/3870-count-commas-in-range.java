class Solution {
    public int countCommas(int n) {
        int a=0;
        for(int p=1000;p<=n;p*=1000){
            a+=n-p+1;
        }
        return a;
    }
}