import java.io.*;
import java.util.*;
public class where {
	static int n;
	static String[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("where.in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
		StringTokenizer st = new StringTokenizer(f.readLine(), " ");
		n = Integer.parseInt(st.nextToken().trim());
		board = new String[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine(), " ");
			String[] s = st.nextToken().trim().split("");
			for (int j = 0; j < n; j++) board[i][j] = s[j];
		}
		for (int x1 = 0; x1 < n; x1++) {
			for (int y1 = 0; y1 < n; y1++) {
				for (int x2 = 0; x2 < n; x2++) {
					for (int y2 = 0; y2 < n; y2++) {
						if (has2distinct(x1, x2, y1, y2)) {
							
						}
					}
				}
			}
		}
		f.close();
		out.close();

	}
	public static boolean has2distinct(int r1, int  r2, int c1, int c2) {
		HashSet<String> hs = new HashSet<String>();
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				hs.add(board[i][j]);
			}
		}
		return hs.size() == 2;
	}
}
