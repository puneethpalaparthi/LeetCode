class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        List<List<Integer>> leftSums = new ArrayList<>();
        List<List<Integer>> rightSums = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            leftSums.add(new ArrayList<>());
            rightSums.add(new ArrayList<>());
        }

        generateSubsetSums(nums, 0, n, 0, 0, leftSums);
        generateSubsetSums(nums, n, 2 * n, 0, 0, rightSums);

        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSums.get(i));
        }

        int minDiff = Integer.MAX_VALUE;
        int target = totalSum / 2;

        for (int k = 0; k <= n; k++) {
            List<Integer> left = leftSums.get(k);
            List<Integer> right = rightSums.get(n - k);

            for (int sumL : left) {
                int remainingTarget = target - sumL;
                int idx = Collections.binarySearch(right, remainingTarget);
                
                if (idx >= 0) {
                    return Math.abs(totalSum - 2 * (sumL + right.get(idx)));
                } else {
                    idx = -(idx + 1);
                    if (idx < right.size()) {
                        minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (sumL + right.get(idx))));
                    }
                    if (idx > 0) {
                        minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (sumL + right.get(idx - 1))));
                    }
                }
            }
        }

        return minDiff;
    }

    private void generateSubsetSums(int[] nums, int start, int end, int count, int currentSum, List<List<Integer>> sums) {
        if (start == end) {
            sums.get(count).add(currentSum);
            return;
        }
        generateSubsetSums(nums, start + 1, end, count + 1, currentSum + nums[start], sums);
        generateSubsetSums(nums, start + 1, end, count, currentSum, sums);
    }
}