class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        for(int i = 0; i <= n; i++) {

            while(!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])) {
                int h = heights[stack.pop()];
                int b = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, b * h);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
