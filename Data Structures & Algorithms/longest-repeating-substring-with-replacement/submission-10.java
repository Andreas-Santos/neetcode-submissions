class Solution {
    public int characterReplacement(String s, int k) {
        
        int longest = 0;
        int mostRepeated = 0;
        int[] freq = new int[26];

        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            freq[c - 'A']++;
            mostRepeated = Math.max(mostRepeated, freq[c - 'A']);

            while(r - l + 1 - mostRepeated > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
