class Solution {
    public long countPairs(int[] nums, int k) {
        long count = 0;
        Map<Integer, Integer> gcdCounts = new HashMap<>();

        for (int num : nums) {
            int currentGcd = gcd(num, k);
            
            for (Map.Entry<Integer, Integer> entry : gcdCounts.entrySet()) {
                if ((long) currentGcd * entry.getKey() % k == 0) {
                    count += entry.getValue();
                }
            }
            
            gcdCounts.put(currentGcd, gcdCounts.getOrDefault(currentGcd, 0) + 1);
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}