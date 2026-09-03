class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd=Integer.MAX_VALUE,minEven=Integer.MAX_VALUE;
        for(int x:nums1){
            if(x%2==0) minEven=Math.min(minEven,x);
            else minOdd=Math.min(minOdd,x);
        }
        boolean odd=true,even=true;
        for(int x:nums1){
            if(x%2==0&&minOdd>=x) odd=false;
            if(x%2!=0&&minOdd>=x) even=false;
        }
        return odd||even;
    }
}