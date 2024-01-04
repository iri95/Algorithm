package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9655_돌게임 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		if(a%2 == 1) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}

	}

}
