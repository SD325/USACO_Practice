import java.util.*;
import java.io.*;
public class _template {
	static int n;
	static String program_name = "_template";
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(program_name + ".in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(program_name + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		
		f.close();
		out.close();
	}

}
