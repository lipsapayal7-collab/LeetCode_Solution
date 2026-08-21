class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long l=1;
        long h=(long) coins[0]*k;
        java.util.Arrays.sort(coins);
        int n=coins.length,m=0;
        for(int i=0;i<n;i++){
            boolean r=false;
            for(int j=0;j<m;j++){
                if(coins[i]%coins[j]==0){
                    r=true;
                    break;
                }
            }
            if(!r){
                coins[m++]=coins[i];
            }
        }
        n=m;
        while(l<h){
            long mid=l+(h-l)/2;
            if(count(mid,coins,n)>=k){
                h=mid;
            }
            else l=mid+1;
        }
        return l;
    }
    private long count(long x,int[] coins,int n){
        long res=0;
        for(int mk=1;mk<(1<<n);mk++){
            long lcm=1;
            int b=0;
            boolean o=false;
            for(int i=0;i<n;i++){
                if((mk&(1<<i))!=0){
                    b++;
                    long g=gcd(lcm,coins[i]);
                    if(lcm>x/(coins[i]/g)){
                        o=true;
                        break;
                    }
                    lcm=lcm/g*coins[i];
                    if(lcm>x){
                        o=true;
                        break;
                    }
                }
            }
            if(!o){
                long multi=x/lcm;
                if(b%2==1) res+=multi;
                else res-=multi;
            }
        }
        return res;
    }
    private long gcd(long a,long b){
        while(b!=0){
            long temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}