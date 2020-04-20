import java.util.*;
import java.io.*;
public class multimoo {
	static int n;
	static int[][] board;
	static int count;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		String problem = "multimoo";
		BufferedReader f = new BufferedReader(new FileReader(problem + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problem + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		board = new int[n][n];
		visited = new boolean[n][n];
		int max = -1;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < n; j++) {
				int val = Integer.parseInt(st.nextToken());
				board[i][j] = val;
				max = Math.max(max, val);
			}
		}
		int maxNum = -1;
		Node[] nodes = new Node[max+1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					count = 0;
					int num = board[i][j];
					dfs(i, j, num);
					maxNum = Math.max(maxNum, count);
				}
			}
		}
		System.out.println(maxNum);
		
		f.close();
		out.close();
	}
	public static void dfs(int r, int c, int num) {
		if (r >= n || c >= n || r < 0 || c < 0) return;
		if (visited[r][c] || board[r][c] != num) return;
		visited[r][c] = true;
		count++;
		dfs(r+1, c, num);
		dfs(r-1, c, num);
		dfs(r, c+1, num);
		dfs(r, c-1, num);
	}
}
class Node {
	public int id;
	public int val;
	public Node(int id, int val) {
		this.id = id;
		this.val = val;
	}
}