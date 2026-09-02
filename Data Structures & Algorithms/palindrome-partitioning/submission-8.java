class Solution {
    List<List<String>> partitions;
    List<String> current;

    public List<List<String>> partition(String s) {
        partitions = new ArrayList<>();
        current = new ArrayList<>();

        dfs(s, 0);

        return partitions;
    }

    public void dfs(String s, int i) {
        if(i == s.length()) {
            partitions.add(new ArrayList<>(current));
            return;
        }

        for(int j = i; j < s.length(); j++) {
            if(isPalindrome(s, i, j)) {
                current.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int l, int r) {
        while(l <= r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
