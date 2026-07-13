class Solution {
    public int kSimilarity(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(s1);
        visited.add(s1);
        int swaps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String curr = queue.poll();
                if (curr.equals(s2)) {
                    return swaps;
                }
                
                int i = 0;
                while (i < curr.length() && curr.charAt(i) == s2.charAt(i)) {
                    i++;
                }
                
                for (int j = i + 1; j < curr.length(); j++) {
                    if (curr.charAt(j) == s2.charAt(i) && curr.charAt(j) != s2.charAt(j)) {
                        String next = swap(curr, i, j);
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            swaps++;
        }
        
        return swaps;
    }
    
    private String swap(String s, int i, int j) {
        char[] ca = s.toCharArray();
        char temp = ca[i];
        ca[i] = ca[j];
        ca[j] = temp;
        return new String(ca);
    }
}