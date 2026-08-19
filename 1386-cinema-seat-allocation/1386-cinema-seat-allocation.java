import java.util.*;
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Set<Integer>> map=new HashMap<>();
        for(int[] s:reservedSeats){
            int r=s[0];
            int c=s[1];
            map.putIfAbsent(r,new HashSet<>());
            map.get(r).add(c);
        }
        int a=(n-map.size())*2;
        for(Set<Integer> s:map.values()){
            boolean l=true;
            boolean m=true;
            boolean r=true;
            for(int i=2;i<=5;i++){
                if(s.contains(i)){
                    l=false;
                    break;
                }
            }
            for(int i=4;i<=7;i++){
                if(s.contains(i)){
                    m=false;
                    break;
                }
            }
            for(int i=6;i<=9;i++){
                if(s.contains(i)){
                    r=false;
                    break;
                }
            }
            if(l&&r){
                a+=2;
            }
            else if(l || m|| r){a+=1;}
        }
        return a;
    }
}