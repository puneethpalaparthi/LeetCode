class Solution {
    public boolean check(int[] nums) {
        boolean check=false;
        int j=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                j=i;
                check = true;
                break;
            }    
        }
        if(j==nums.length-1){
            if(nums[j]>nums[0])
                return false;
        }
        if(check)
            for(int i=j+1;i<nums.length;i++){
                if(nums[i]<nums[i-1] || nums[i]>nums[0]){
                    return false;
                }
            }
            
        return true;
    }
}