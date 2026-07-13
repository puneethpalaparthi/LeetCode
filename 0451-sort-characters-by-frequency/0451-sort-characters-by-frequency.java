class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        List<Character>[] buckets = new List[s.length() + 1];
        for (char c : counts.keySet()) {
            int frequency = counts.get(c);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}