package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9659_돌게임5 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long a = Long.parseLong(br.readLine());
		if(a%2 == 1) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}

	}

}
