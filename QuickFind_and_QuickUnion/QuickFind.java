class UF {
    private int[]id;
    public UF(int N) {
        System.out.println("Set node number to " + N);
        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    } 
    public void union(int p, int q) {
        if(id[p] == id[q]) return;

        int fromVal = id[p];
        int toVal = id[q];
        for(int i = 0; i < id.length; i++) {
            if(id[i] == fromVal) {
                id[i] = toVal;
            }
        }
    }
}
/*
Algorithm : Quick Find.
Cost : 
init / union / find
N / N / 1
*/
public class QuickFind {
    
    public static void main(String[] args) {
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