class Solution {
    public boolean isPerfectSquare(int num) {
        int l=1,r=num;
        while(l<=r){
            int m=l+(r-l)/2;
            if(m==num/m && num%m==0){
                return true;
            } 
            else if(m<num/m){
                l=m+1;
            }
            else{
                r=m-1;
            }
        }
        return false;
    }
}