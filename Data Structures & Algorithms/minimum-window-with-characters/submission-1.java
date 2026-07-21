class Solution {

    public String minWindow(String s, String t) {
       
        if(t.length() > s.length()) return "";

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int need = mapT.size();
        int current = 0;

        int leftSub = -1;
        int length = Integer.MAX_VALUE;

        int l = 0;
        for(int r = 0; r < s.length() && l < s.length(); r++) {
                        
            char c = s.charAt(r);
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
            if(mapT.containsKey(c) && mapT.get(c) == mapS.get(c)) {
                current++;
            }

            while(current == need) {

                if(r - l + 1 < length) {
                    length = r - l + 1;
                    leftSub = l;
                }

                c = s.charAt(l);
                mapS.put(c, mapS.getOrDefault(c, 0) - 1);
                if(mapT.containsKey(c) && mapT.get(c) - 1 == mapS.get(c)) {
                    current--;
                }

                l++;
            }
        }

        if(length == Integer.MAX_VALUE) return "";

        return s.substring(leftSub, leftSub + length);
    }
}
