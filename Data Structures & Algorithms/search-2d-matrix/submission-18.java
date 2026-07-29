class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = m * n - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int value = matrix[mid / n][mid % n];

            if(target == value) return true;

            if(value < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return false;
    }
}
