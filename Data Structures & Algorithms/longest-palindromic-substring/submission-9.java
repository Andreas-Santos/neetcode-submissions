class Solution {
    public String longestPalindrome(String s) {
        
        int longestSize = 0;
        int longestStart = 0;

        for(int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if(longestSize < r - l + 1) {
                    longestSize = r - l + 1;
                    longestStart = l;
                }

                l--;
                r++;
            }

            l = i;
            r = i+1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if(longestSize < r - l + 1) {
                    longestSize = r - l + 1;
                    longestStart = l;
                }

                l--;
                r++;
            }
        }

        return s.substring(longestStart, longestStart + longestSize);
    }
}
