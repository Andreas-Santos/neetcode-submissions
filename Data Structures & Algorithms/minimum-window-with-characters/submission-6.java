class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length()) return "";

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char c : t.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int need = map1.size();
        int current = 0;
        int minWindow = Integer.MAX_VALUE;
        int startIndex = -1;

        int l = 0;
        for(int r = 0; r < s.length(); r++) {

            char c = s.charAt(r);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
            if(map1.containsKey(c) && map2.get(c) == map1.get(c)) {
                current++;
            }

            while(current == need) {
                if(r - l + 1 < minWindow) {
                    minWindow = r - l + 1;
                    startIndex = l;
                }

                c = s.charAt(l);
                map2.put(c, map2.get(c) - 1);
                if(map1.containsKey(c) && map1.get(c) - 1 == map2.get(c)) {
                    current--;
                }

                l++;
            }
        }

        if(minWindow == Integer.MAX_VALUE) return "";

        return s.substring(startIndex, startIndex + minWindow); 
    }
}
