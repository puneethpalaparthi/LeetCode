class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxCal = nums[0], maxAns = nums[0];
        int minCal = nums[0], minAns = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            
            if (i > 0) {
                maxCal = Math.max(nums[i], maxCal + nums[i]);
                maxAns = Math.max(maxAns, maxCal);
                
                minCal = Math.min(nums[i], minCal + nums[i]);
                minAns = Math.min(minAns, minCal);
            }
        }
        
        if (maxAns < 0) {
            return maxAns;
        }
        
        return Math.max(maxAns, totalSum - minAns);
    }
}