class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if(isConnected[r][c] == 1 && r != c) {
                    uf.union(r, c);
                }
            }
        }

        return uf.getProvinces();
    }
}

class UnionFind {

    private int[] parent;
    private int[] rank;
    private int provinces;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        provinces = n;

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) {
            return false;
        }

        if(rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        }
        else if(rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        }
        else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        
        provinces--;

        return true;
    }

    public int getProvinces() {
        return provinces;
    }
}