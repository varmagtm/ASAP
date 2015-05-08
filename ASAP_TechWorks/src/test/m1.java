package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class m1 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String message = bufferedReader.readLine();
		StringBuffer buffer = new StringBuffer(message);
		System.out.print(buffer.reverse());
	}
}