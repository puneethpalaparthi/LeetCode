import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        Integer[] numsCopy = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsCopy[i] = nums[i];
        }
        Arrays.sort(numsCopy, (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            
            if (freqA != freqB) {
                return Integer.compare(freqA, freqB);
            }
            return Integer.compare(b, a);
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsCopy[i];
        }

        return nums;
    }
}