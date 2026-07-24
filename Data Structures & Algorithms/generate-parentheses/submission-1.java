class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    public void backtrack(List<String> result, StringBuilder cur, int open, int close, int max) {

        if(cur.length() == max * 2) {
            result.add(cur.toString());
            return;
        }

        if(open < max) {
            cur.append('(');
            backtrack(result, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        if(close < open) {
            cur.append(')');
            backtrack(result, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
