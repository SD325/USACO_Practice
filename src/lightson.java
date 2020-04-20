import java.util.*;
import java.io.*;
public class lightson {
	static int n;
	static int m;
	static boolean on[][];
	static boolean visited[][];
	static HashMap<ArrayList<Integer>, ArrayList<ArrayList<Integer>>> lights = new HashMap<>();
	static int[] dx = new int[]{-1,1,0,0};
	static int[] dy = new int[]{0,0,-1,1};
	public static void main(String[] args) throws IOException {
		String problem = "lightson";
		BufferedReader f = new BufferedReader(new FileReader(problem + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problem + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		on = new boolean[n+1][n+1];
		visited = new boolean[n+1][n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ArrayList<Integer> key = new ArrayList<Integer>(Arrays.asList(x, y));
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()); 
			addToMap(key, new ArrayList<Integer>(Arrays.asList(a, b)));
		}
		on[1][1] = true;
		dfs(1,1);
		int count = 0;
		for (boolean[] row : on) {
			for (boolean b : row)
				if (b) count++;
		}
		System.out.println(count);
		f.close();
		out.close();
	}
	public static void dfs(int r, int c) {
		if (r > n || r <= 0 || c > n || c <= 0) return;
		if (!on[r][c] || visited[r][c]) return;
		visited[r][c] = true;
		ArrayList<Integer> pos = new ArrayList<Integer>(Arrays.asList(r, c));
		if (!lights.containsKey(pos)) return;
		ArrayList<ArrayList<Integer>> temp = lights.get(pos);
		for (ArrayList<Integer> al : temp) {
			int r1 = al.get(0);
			int c1 = al.get(1);
			on[r1][c1] = true;
			if (isNextTo(r1, c1)) dfs(r1, c1);
		}
		dfs(r, c-1);
		dfs(r, c+1);
		dfs(r-1, c);
		dfs(r+1, c);
	}
	public static boolean isNextTo(int r1, int c1) {
		for (int i = 0; i < 4; i++) {
			int r = r1 + dx[i];
			int c = c1 + dy[i];
			if (r > n || r <= 0 || c > n || c <= 0) continue;
			if (on[r][c] && visited[r][c]) return true;
		}
		return false;
	}
	public static void addToMap(ArrayList<Integer> key, ArrayList<Integer> toAdd) {
		if (!lights.containsKey(key)) {
			lights.put(key, new ArrayList<ArrayList<Integer>>());
		}
		ArrayList<ArrayList<Integer>> temp = lights.get(key);
		temp.add(toAdd);
		lights.put(key, temp);
	}
}
