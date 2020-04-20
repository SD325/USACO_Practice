import java.io.*;
import java.util.*;
public class citystate {
	public static int n;
	public static HashMap<String, Integer> code_count;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("citystate.in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		StringTokenizer st = new StringTokenizer(f.readLine(), " ");
		n = Integer.parseInt(st.nextToken().trim());		
		code_count = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine(), " ");
			String city = (st.nextToken().trim()).substring(0, 2);
			String state = st.nextToken().trim();
			if (!city.equals(state)) {
				String key = city + state;
				if (!code_count.containsKey(key)) {
					code_count.put(key, 0);
				}
				code_count.put(key, code_count.get(key) + 1);
			}
		}

		int count = 0;
		for (String key : code_count.keySet()) {
			String opp_key = key.substring(2, 4) + key.substring(0, 2);
			if (code_count.containsKey(opp_key)) count += code_count.get(key) * code_count.get(opp_key);
		}
		out.println(count/2);
		f.close();
		out.close();
	}
}
