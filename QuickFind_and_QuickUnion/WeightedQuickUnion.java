class UF2 {
    private int[]id;
    private int[]sz;

    public UF2(int N) {
        System.out.println("Set node number to " + N);
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++) {
            sz[i] = 1;
            id[i] = i;
        }
    }
    public int get_root(int p) {
        int root = p;
        while(id[root] != root) {
            //improve2. path compression
            id[root] = id[id[root]];
            root = id[root];
        }
        return root;
    }
    public boolean connected(int p, int q) {
        return get_root(p) == get_root(q);
    } 
    public void union(int p, int q) {
        //way1. 1 - self
        //id[p] = q;

        //way2. N - course
        int i = get_root(p);
        int j = get_root(q);
        // j(root) -- > i(leaf)
        //id[i] = j;
        if(i > j) {
            id[j] = i;
        } else {
            id[i] = j;
        }
    }
    public void print() {
        for(int i = 0; i < id.length; i++) {
            System.out.print(" " + id[i]);
        }
        
    }
}
/*
Algorithm : Weighted Quick Union.
Using tree architecture, to find nodes share same root or not
For root case : id[root] == root
Add weigh function, each union make sure that small under big tree
so the tree won't be too tall

Cost : 
M union-find on N objects.
Cost :
Quick Find : MN
Quick Union : MN
Weighted Quick Union : N + MlogN
Quick Union + path compression : N + MlogN
WQUPC : N + MlgN
*/
public class WeightedQuickUnion {  
    public static void main(String[] args) {
        System.out.println("Quick Unionxx...");
        UF2 uf = new UF2(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        System.out.println(uf.connected(0, 7));
        System.out.println(uf.connected(8, 9));
        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        uf.union(1, 0);
        System.out.println(uf.connected(0, 7));   
        uf.print();
    }
}