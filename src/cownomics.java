import java.io.*;
import java.util.*;
public class cownomics {
	static int n, m;
	static String[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("pairup.in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
		StringTokenizer st = new StringTokenizer(f.readLine(), " ");
		n = Integer.parseInt(st.nextToken().trim());
		m = Integer.parseInt(st.nextToken().trim());
		
		f.close();
		out.close();

	}

}
