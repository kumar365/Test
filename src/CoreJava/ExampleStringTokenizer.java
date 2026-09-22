package CoreJava;
import java.util.*;

public class ExampleStringTokenizer {
	public static void main(String[] args) {
		String str = "one,two,three,four,five,six,seven,eight,nine,ten";
		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println("Count of Tokens:"+st.countTokens());
		while (st.hasMoreTokens()) { // has MoreElements
			System.out.println(st.nextToken());
		}
	}
}
