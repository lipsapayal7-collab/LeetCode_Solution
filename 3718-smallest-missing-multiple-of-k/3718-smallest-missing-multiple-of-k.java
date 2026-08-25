class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int m=k;
        while(set.contains(m)){
            m+=k;
        }
        return m;
    }
}