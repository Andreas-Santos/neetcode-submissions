class Solution {
    
    private List<String> combinations;
    private final String[] lettersMap = new String[]{
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }

        combinations = new ArrayList<>();

        dfs(digits, 0, new StringBuilder());

        return combinations;
    }

    public void dfs(String digits, int i, StringBuilder current) {

        if(i == digits.length()) {
            combinations.add(current.toString());
            return;
        }

        char digit = digits.charAt(i);
        for(char letter : lettersMap[digit - '0'].toCharArray()) {
            current.append(letter);
            dfs(digits, i + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
