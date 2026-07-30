class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        // Map1 and Map2 approach
        // need variable, current variable
        // return true if need == current

        if(s1.length() > s2.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int need = map1.size();
        int current = 0;

        int l = 0;
        for(int r = 0; r < s2.length(); r++) {

            if(current == need) return true;

            char c = s2.charAt(r);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
            if(map1.containsKey(c) && map1.get(c) == map2.get(c)) {
                current++;
            }
            else if(map1.containsKey(c) && map1.get(c) + 1 == map2.get(c)) {
                current--;
            }

            if(r - l >= s1.length()) {
                c = s2.charAt(l);
                map2.put(c, map2.get(c) - 1);
                if(map1.containsKey(c) && map1.get(c) == map2.get(c)) {
                    current++;
                }
                else if(map1.containsKey(c) && map1.get(c) - 1 == map2.get(c)) {
                    current--;
                }

                l++;
            }

        }

        return need == current;
    }
}
