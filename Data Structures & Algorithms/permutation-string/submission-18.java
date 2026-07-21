class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        int need = map1.size();
        int current = 0;
        for(char key : map1.keySet()) {
            if(map2.containsKey(key) && map2.get(key) == map1.get(key)) {
                current++;
            }
        }

        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++) {

            if(need == current) return true;

            char c = s2.charAt(r);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
            if(map1.containsKey(c) && map1.get(c) == map2.get(c)) {
                current++;
            }
            else if(map1.containsKey(c) && map1.get(c) + 1 == map2.get(c)) {
                current--;
            }

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

        return need == current;
    }
}
