class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int[] count = new int[nums.length + 1];
        int left = 0, distinct = 0, totalSubarrays = 0;

        for (int right = 0; right < nums.length; right++) {
            if (count[nums[right]] == 0) {
                distinct++;
            }
            count[nums[right]]++;

            while (distinct > k) {
                count[nums[left]]--;
                if (count[nums[left]] == 0) {
                    distinct--;
                }
                left++;
            }

            totalSubarrays += (right - left + 1);
        }

        return totalSubarrays;
    }
}