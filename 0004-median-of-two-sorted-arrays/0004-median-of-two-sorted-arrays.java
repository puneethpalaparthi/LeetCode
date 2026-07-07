class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int[] ans = new int[nums1.length + nums2.length];

        while (i < nums1.length && j < nums2.length)
            ans[k++] = (nums1[i] <= nums2[j]) ? nums1[i++] : nums2[j++];
        while (i < nums1.length) ans[k++] = nums1[i++];
        while (j < nums2.length) ans[k++] = nums2[j++];
        int n = ans.length;
        if (n % 2 == 1)
            return ans[n / 2];
        return (ans[n/2 - 1] + ans[n/2]) / 2.0;
    
       
    }
}