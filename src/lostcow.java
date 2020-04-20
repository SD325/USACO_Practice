import java.io.*;
import java.util.*;
public class lostcow {
	static int cow;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("lostcow.in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int i_x = Integer.parseInt(st.nextToken().trim());
		cow = Integer.parseInt(st.nextToken().trim());
		
		int x = i_x;
		int exp = 0;
		boolean direction = true;
		boolean b = true;
		int total = 0;
		while (b) {
			if (direction) {
				int old = x;
				x = (i_x + (int) Math.pow(2, exp));
				total += Math.abs(old - x);
				if ((x >= cow) && (cow > i_x)) {
					total -= Math.abs(x - cow);
					b = false;
				}
			}
			else {
				int old = x;
				x = (i_x - (int) Math.pow(2, exp));
				total += Math.abs(old - x);
				if ((x <= cow) && (cow < i_x)) {
					total -= Math.abs(x - cow);
					b = false;
				}
			}
			exp++;
			direction = (!direction);
		}
		out.println(total);
		f.close();
		out.close();		
	}

}
