import java.util.*;
import java.io.*;
public class ClosingTheFarm {
	static int n, m;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	static String program_name = "closing";
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(program_name + ".in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(program_name + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] first = new int[m]; int[] second = new int[m];
		for (int i = 0; i < n; i++) adj.add(new ArrayList<Integer>());
		for (int i = 0; i < m ; i++) {
			st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			first[i] = a; second[i] = b;
		}
		int[] order = new int[n];
		int[] place = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			order[n-1-i] = a;
			place[a] = n-1-i;
		}
		for (int i = 0; i < m; i++) {
			if (place[first[i]] > place[second[i]]) 
				adj.get(first[i]).add(second[i]);
			else 
				adj.get(second[i]).add(first[i]);
		}
		int conn_comps = 0;
		Stack<Boolean> ans = new Stack<Boolean>();
		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < n; i++) {
			int a = order[i];
			conn_comps++;
			for (int b : adj.get(a)) {
				if (!uf.connected(a, b)) {
					uf.union(a, b);
					conn_comps--;
				}
			}
			ans.add(conn_comps <= 1);
		}
//		System.out.println(ans);
		while (!ans.isEmpty()) {
			if (ans.pop()) {
				out.println("YES");
			}
			else {
				out.println("NO");
			}
		}
		f.close();
		out.close();
	}

}

class UnionFind {
	private int[] parent;
	private int[] size;  // only correct for root nodes
	public int count;
	
	public UnionFind(int n) {
		count = n;
		parent = new int[n];
		size = new int[n];
		
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}
	
	public int find(int p) {
		// with path compression
		int root = p;
		// find root
		while (root != parent[root]) root = parent[root];
		while (p != root) {
			int newp = parent[p];
			parent[p] = root;
			p = newp;
		}
		return root;		
	}
	
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) return;
		
		if (size[rootP] < size[rootQ]) {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}
		else {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		}
		count--;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
}