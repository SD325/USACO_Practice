import java.util.*;
import java.io.*;
public class countcross {
	static int n;
	static int cows_count;
	static int roads_count;
	static int[][] grid;
	static int id;
	static ArrayList<ArrayList<Integer>> cows = new ArrayList<>();
	static HashMap<ArrayList<Integer>, ArrayList<ArrayList<Integer>>> roads = new HashMap<>();
	static HashMap<Integer, Integer> cow_id = new HashMap<>(); 
	public static void main(String[] args) throws IOException {
		String problem = "countcross";
		BufferedReader f = new BufferedReader(new FileReader(problem + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problem + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		cows_count = Integer.parseInt(st.nextToken());
		roads_count = Integer.parseInt(st.nextToken());
		grid = new int[n+1][n+1];
		for (int i = 0; i < roads_count; i++) {
			st = new StringTokenizer(f.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			ArrayList<Integer> p1 = new ArrayList<>(Arrays.asList(x1, y1));
			ArrayList<Integer> p2 = new ArrayList<>(Arrays.asList(x2, y2));
			addToMap(p1, p2);
			addToMap(p2, p1);
		}
		for (int i = 0; i < roads_count; i++) {
			st = new StringTokenizer(f.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			ArrayList<Integer> p1 = new ArrayList<>(Arrays.asList(x1, y1));
			cows.add(p1);
		}
		id = 1;
		for (ArrayList<Integer> loc : cows) { //floodfill for each cow
			if (grid[loc.get(0)][loc.get(1)] == 0) floodfill(loc.get(0), loc.get(1));
			id++;
		}
		for (ArrayList<Integer> loc : cows) { //floodfill for each cow
			int currId = grid[loc.get(0)][loc.get(1)];
			if (!cow_id.containsKey(currId)) cow_id.put(currId, 0);
			cow_id.put(currId, cow_id.get(currId)+1);
		}
		int prod = 1;
		for (Integer i : cow_id.keySet()) prod *= i;
		out.println(prod);
		f.close();
		out.close();
	}
	public static void floodfill(int r, int c) {
		if (r > n || c > n || r <= 0 || c <= 0) return;
		if (grid[r][c] != 0) return;
		grid[r][c] = id;
		ArrayList<Integer> loc = new ArrayList<>(Arrays.asList(r, c));
		ArrayList<ArrayList<Integer>> isRoad = roads.get(loc);
		int[] r_change = {1, -1, 0, 0};
		int[] c_change = {0, 0, 1, -1};
		for (int i = 0; i < 4; i++) {
			if (isRoad == null) floodfill(r + r_change[i], c + c_change[i]);
			else {
				loc = new ArrayList<>(Arrays.asList(r + r_change[i], c + c_change[i]));
				if (!isRoad.contains(loc)) floodfill(r + r_change[i], c + c_change[i]);
			}
		}
		
	}
	public static void addToMap(ArrayList<Integer> p1, ArrayList<Integer> p2) {
		if (!roads.containsKey(p1)) {
			roads.put(p1, new ArrayList<ArrayList<Integer>>());
		}
		ArrayList<ArrayList<Integer>> temp = roads.get(p1);
		temp.add(p2);
		roads.put(p1, temp);
	}
}
