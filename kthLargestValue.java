class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int[][] ans = new int[matrix.length+1][matrix[0].length+1];
        Queue<Integer> queue=new PriorityQueue<>();
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                ans[i+1][j+1] = ans[i+1][j]^ans[i][j+1]^ans[i][j]^matrix[i][j];
                queue.offer(ans[i+1][j+1]);
                if (queue.size()>k) queue.poll();
            }
        }
        return queue.poll();
    }
}
