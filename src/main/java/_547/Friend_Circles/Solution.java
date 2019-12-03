package _547.Friend_Circles;

public class Solution {
    /**
     * 并查集
     *
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        if (M.length == 0) {
            return 0;
        }
        int N = M.length;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }

    class UnionFind {
        int[] roots;
        int count;

        public UnionFind(int n) {
            roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }
            count = n;
        }

        public int findRoot(int p) {
            int root = p;
            while (root != roots[root]) {
                root = roots[root];
            }
            int parent = p;
            while (parent != roots[parent]) {
                int tmp = roots[parent];
                roots[parent] = root;
                parent = tmp;
            }
            return root;
        }

        public void union(int p1, int p2) {
            int root1 = findRoot(p1);
            int root2 = findRoot(p2);
            if (root1 != root2) {
                roots[root2] = root1;
                count --;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
