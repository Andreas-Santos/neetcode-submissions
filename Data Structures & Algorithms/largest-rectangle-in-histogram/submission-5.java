class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int largestArea = 0;

        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        for(int i = 0; i <= n; i++) {

            int current = i == n ? 0 : heights[i];

            while(!stack.isEmpty() && current < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int base = stack.isEmpty() ? i : i - stack.peek() - 1;
                largestArea = Math.max(largestArea, base * h);
            }

            stack.push(i);
        }

        return largestArea;
    }
}
