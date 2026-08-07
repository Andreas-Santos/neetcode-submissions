class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            int[] freq = new int[26];
            for(char c : str.toCharArray()) {
                freq[c - 'a']++;
            }

            String freqString = Arrays.toString(freq);
            if(!map.containsKey(freqString)) {
                map.put(freqString, new ArrayList<>());
            }

            map.get(freqString).add(str);
        }

        List<List<String>> result = new ArrayList<>();

        for(List<String> value : map.values()) {
            result.add(value);
        }

        return result;
    }
}
