class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, new StringBuilder(), n, 0, 0);
        return result;
    }

    public void backtrack(List<String> result, StringBuilder current, int max, int open, int close) {
        if(current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        if(open < max) {
            current.append("(");
            backtrack(result, current, max, open + 1, close);
            current.deleteCharAt(current.length() - 1);
        }

        if(close < open) {
            current.append(")");
            backtrack(result, current, max, open, close + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
