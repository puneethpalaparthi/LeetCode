import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[uniqueCount++] = nums[i];
            }
        }
        
        int maxWindow = 0;
        int right = 0;
        
        for (int left = 0; left < uniqueCount; left++) {
            while (right < uniqueCount && nums[right] < nums[left] + n) {
                right++;
            }
            maxWindow = Math.max(maxWindow, right - left);
        }
        
        return n - maxWindow;
    }
}