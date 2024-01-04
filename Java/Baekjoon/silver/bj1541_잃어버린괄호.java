package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj1541_잃어버린괄호 {

	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		String[] stringMinus = string.split("\\-");
		int[] adds = new int[stringMinus.length];
		for (int i = 0; i < stringMinus.length; i++) {
			String[] add = stringMinus[i].split("\\+");
			for (int j = 0; j < add.length; j++) {
				adds[i] += Integer.parseInt(add[j]);
			}
		}
		int result = adds[0];
		for (int i = 1; i < adds.length; i++) {
			result -= adds[i];
		}
		System.out.println(result);
		
		
	}
}
