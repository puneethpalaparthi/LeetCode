class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] frequency = new int[101]; 
        int maxFreq = 0;
        int totalMaxFreqElements = 0;

        for (int num : nums) {
            frequency[num]++;
            int currentFreq = frequency[num];

            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                totalMaxFreqElements = currentFreq;
            } else if (currentFreq == maxFreq) {
                totalMaxFreqElements += currentFreq;
            }
        }

        return totalMaxFreqElements;
    }
}