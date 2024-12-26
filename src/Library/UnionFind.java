package Library;
// https://qiita.com/aja_min/items/ef6603f1cbabca0739ea
class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        // 初期化コンストラクタ
        this.parent = new int[n];
        this.rank = new int[n];

        // 最初はすべてが根
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    /**
     * 要素の根を返す。
     * 経路圧縮付き。（1→3→2となっていて2をfindした際、1→3,2と木の深さを浅くする。）
     *
     * @param x
     * @return 要素xの根
     */
    public int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            // 経路圧縮時はrank変更しない
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    /**
     * ２つの要素が同じ集合に属するかどうかを返す。
     *
     * @param x
     * @param y
     * @return 同じ集合であればtrue
     */
    public boolean same(int x, int y) {
        return find(x) == find(y);
    }

    /**
     * 要素xが属する集合と要素yが属する集合を連結する。
     * 木の高さ（ランク）を気にして、低い方に高い方をつなげる。（高い方の根を全体の根とする。）
     *
     * @param x
     * @param y
     */
    public void unite(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) {
            // 属する集合が同じな場合、何もしない
            return;
        }

        // rankを比較して共通の根を決定する。
        // ※find時の経路圧縮はrank考慮しない
        if (rank[xRoot] > rank[yRoot]) {
            // xRootのrankのほうが大きければ、共通の根をxRootにする
            parent[yRoot] = xRoot;
        } else if (rank[xRoot] < rank[yRoot]) {
            // yRootのrankのほうが大きければ、共通の根をyRootにする
            parent[xRoot] = yRoot;
        } else {
            // rankが同じであれば、どちらかを根として、rankを一つ上げる。
            parent[xRoot] = yRoot;
            rank[xRoot]++;
        }
    }
}

