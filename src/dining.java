import java.util.*;
import java.util.stream.Stream;
import java.io.*;
public class dining {
	static int n, m, k;
	static HashMap<Integer, Integer> neighbors = new HashMap<Integer, Integer>();
	static String program_name = "dining";
	public static void shortestPaths(List<Edge>[] edges, int s, int[] prio) {
		//Arrays.fill(pred, -1);
		Arrays.fill(prio, Integer.MAX_VALUE);
		prio[s] = 0;
		PriorityQueue<Long> q = new PriorityQueue<>();
		q.add((long) s);
		while (!q.isEmpty()) {
			long cur = q.remove();
			int curu = (int) cur;
			if (cur >>> 32 != prio[curu])
				continue;
			for (Edge e : edges[curu]) {
				int v = e.t;
				int nprio = prio[curu] + e.cost;
				if (prio[v] > nprio) {
					prio[v] = nprio;
					//pred[v] = curu;
					q.add(((long) nprio << 32) + v);
				}
			}
		}
	}

	static class Edge {
		int t, cost;

		public Edge(int t, int cost) {
			this.t = t;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader(program_name + ".in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(program_name + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		List<Edge>[] graph = Stream.generate(ArrayList::new).limit(2*m).toArray(List[]::new);
		List<Edge>[] graph_copy = Stream.generate(ArrayList::new).limit(2*m).toArray(List[]::new);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());  
			int cost = Integer.parseInt(st.nextToken());
			graph[a-1].add(new Edge(b-1, cost));
			graph[b-1].add(new Edge(a-1, cost));
			if (a != n && b != n) {
				graph_copy[a-1].add(new Edge(b-1, cost));
				graph_copy[b-1].add(new Edge(a-1, cost));
			}
		}
		int[] dist_to_final = new int[n];
		shortestPaths(graph, n-1, dist_to_final);

		HashMap<Integer, Integer> loc_to_haybale = new HashMap<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(f.readLine());
			int loc = Integer.parseInt(st.nextToken());
			int yumminess = Integer.parseInt(st.nextToken());
			if (loc_to_haybale.containsKey(loc-1)) {
				int old = loc_to_haybale.get(loc-1);
				int max = Math.max(old, yumminess);
				loc_to_haybale.put(loc-1, max);
			}
			else loc_to_haybale.put(loc-1, yumminess);
		}
		for (int loc : loc_to_haybale.keySet()) graph_copy[n-1].add(new Edge(loc, dist_to_final[loc] - loc_to_haybale.get(loc)));
		for (int i = 0; i < n; i++) {
			System.out.println((i+1) + ":");
			for (Edge e : graph_copy[i]) {
				System.out.println("    " + (e.t+1) + "==> " + e.cost);
			}
			System.out.println("==========");
		}
		int[] new_dist = new int[n];
		shortestPaths(graph_copy, n-1, new_dist);
		for (int i = 0; i < n-1; i++) {
			if (dist_to_final[i] >= new_dist[i]) System.out.println(1);
			else System.out.println(0);
		}
		f.close();
		out.close();
	}
}

