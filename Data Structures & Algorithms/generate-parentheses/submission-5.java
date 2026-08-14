class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        dfs(result, new StringBuilder(), n, 0, 0);

        return result;
    }

    public void dfs(List<String> result, StringBuilder sb, int max, int open, int close) {

        if(sb.length() == max * 2 ) {
            result.add(sb.toString());
            return;
        }

        if(open < max) {
            sb.append("(");
            dfs(result, sb, max, open + 1, close);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close < open) {
            sb.append(")");
            dfs(result, sb, max, open, close + 1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
