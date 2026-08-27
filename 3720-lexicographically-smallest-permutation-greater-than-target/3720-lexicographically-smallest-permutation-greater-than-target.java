class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq=new int[26];
        for(char c:s.toCharArray()) freq[c-'a']++;
        for(int i=target.length()-1;i>=0;i--){
            int[] f=freq.clone();
            for(int j=0;j<i;j++){
                int x=target.charAt(j)-'a';
                if(f[x]==0) break;
                f[x]--;
                if(j==i-1){
                    for(int c=target.charAt(i)-'a'+1;c<26;c++){
                        if(f[c]>0){
                            StringBuilder ans=new StringBuilder(target.substring(0,i));
                            ans.append((char)('a'+c));
                            f[c]--;
                            for(int k=0;k<26;k++)
                                while(f[k]>0){
                                    ans.append((char)('a'+k));
                                    f[k]--;
                                }
                            return ans.toString();
                        }
                    }
                }
            }
            if(i==0){
                for(int c=target.charAt(0)-'a'+1;c<26;c++){
                    if(freq[c]>0){
                        StringBuilder ans=new StringBuilder();
                        ans.append((char)('a'+c));
                        freq[c]--;
                        for(int k=0;k<26;k++)
                            while(freq[k]>0){
                                ans.append((char)('a'+k));
                                freq[k]--;
                            }
                        return ans.toString();
                    }
                }
            }
        }
        return "";
    }
}