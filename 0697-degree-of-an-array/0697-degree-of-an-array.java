import java.util.*;

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> c=new HashMap<>();
        HashMap<Integer,Integer> f=new HashMap<>();
        int degree=0, ans=nums.length;
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            if(!f.containsKey(x))
                f.put(x,i);
            c.put(x,c.getOrDefault(x,0)+1);
            int fr=c.get(x);
            if(fr>degree){
                degree=fr;
                ans=i-f.get(x)+1;
            }
            else if(fr==degree){
                ans=Math.min(ans,i-f.get(x)+1);
            }
        }
        return ans;
    }
}