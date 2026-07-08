class Solution {
    public int strStr(String s, String t) {
        for(int i=0;i<=s.length()-t.length();i++){           
            if(s.charAt(i)==t.charAt(0)){
                int flag=0;
                for(int j=0;j<t.length();j++){
                    if(s.charAt(i+j)!=t.charAt(j)){
                        flag=1;
                        break;
                    }
                }
                if(flag==0){
                    return i;
                }
            }
            
        }
        return -1;
    }
}