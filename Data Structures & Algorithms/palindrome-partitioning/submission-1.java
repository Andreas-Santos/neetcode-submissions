class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> part = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(0, 0, s);
        return res;
    }

    public void dfs(int j, int i, String s) {
        if(i >= s.length()) {
            if(i == j) {
                res.add(new ArrayList<>(part));
            }
            return;
        }

        if(isPalindrome(s, j, i)) {
            part.add(s.substring(j, i + 1));
            dfs(i + 1, i + 1, s);
            part.remove(part.size() - 1);
        }

        dfs(j, i + 1, s);
    }

    public boolean isPalindrome(String str, int l, int r) {
        while(l < r) {
            if(str.charAt(l) != str.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
