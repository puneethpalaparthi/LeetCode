class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int num=x;
        int sum=0;
        int rem;
        while(num!=0){
            rem=num%10;
            sum=(sum*10)+rem;
            num=num/10;
        }
        if(sum==x){
            return true;
        }
        else{
            return false;
        }
    }
}