import java.util.*;
//import java.io.*;

public class trapped {
	static int n;
	public static void main(String[] args) {
		ArrayList<Member> members=new ArrayList<Member>();  
		members.add(new Member("Spandan", 15));  
		members.add(new Member("Sujit", 49));
		members.add(new Member("Sauman", 13));  
		members.add(new Member("Pinky", 42));  
		  
		Collections.sort(members);  
		for(Member m: members){  
		System.out.println(m.name + " " + m.age);  
		}  

	}
	static class Member implements Comparable<Member> {
		public int age;
		public String name;
	    public Member(String inName, int ageIn) {
	      name = inName;
	      age = ageIn;
	      
	    }
	    public int compareTo(Member m) {
	        return age - m.age;
	      }
	}

}
