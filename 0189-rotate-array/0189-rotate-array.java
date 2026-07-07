class Solution {
    
    public static int[] rev(int ar[],int i , int j){
        while(i<j){
            int temp=ar[i];
            ar[i]=ar[j];
            ar[j]=temp;
            i++;
            j--;
        }
        return ar;
    }
    public void rotate(int[] nums, int k) {
          int n=nums.length;
          if(n<=1)
            return ;

          k=k%n;
          rev(nums,0,n-1);
          rev(nums,0,k-1);
          rev(nums,k,n-1);
    }
}