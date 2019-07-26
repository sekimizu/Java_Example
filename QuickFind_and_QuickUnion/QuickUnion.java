class UF {
    private int[]id;
    public UF(int N) {
        System.out.println("Set node number to " + N);
        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    public int get_root(int p) {
        root = p;
        while(id[root] != root) {
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
        id[i] = j;
    }
}
/*
Algorithm : Quick Union.
Using tree architecture, to find nodes share same root or not
For root case : id[root] == root
Cost : 
init / union / find
N / N / N
*/
public class QuickUnion {  
    public static void main(String[] args) {
        System.out.println("Quick Union...");
        UF uf = new UF(10);
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
    }

}