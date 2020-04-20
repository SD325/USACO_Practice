import java.util.*;
import java.io.*;
public class moocast {
	public static int n;
	public static int[][] adj;
	public static boolean[] canHear;
	public static int search(int node) {
		if (canHear[node]) return 0;
		canHear[node] = true;
		int sol = 1; 
		for (int i = 0; i < n; i++) {
			if ((adj[node][i] == 1) && (node != i)) {
				sol += search(i);
			}
		}
		return sol;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("moocast.in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		StringTokenizer st = new StringTokenizer(f.readLine(), " ");
		n = Integer.parseInt(st.nextToken().trim());
		adj = new int[n][n];
		int[] x = new int[n];
		int[] y = new int[n];
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken().trim());
			y[i] = Integer.parseInt(st.nextToken().trim());
			p[i] = Integer.parseInt(st.nextToken().trim());			
		}
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				int distance =  (x[a] - x[b])*(x[a] - x[b]) + (y[a] - y[b])*(y[a] - y[b]);
				if (distance <= p[a] * p[a]) adj[a][b] = 1;
			}
		}
		int sol = 1;
		for (int i = 0; i < n; i++) {
			canHear = new boolean[n]; //avoids double counting
			sol = Math.max(sol, search(i));
		}
		out.println(sol);
		out.close();
		f.close();
	}

}