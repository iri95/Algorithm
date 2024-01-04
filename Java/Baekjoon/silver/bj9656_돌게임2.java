package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9656_돌게임2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		if(a%2 == 1) {
			System.out.println("CY");
		}else {
			System.out.println("SK");
		}

	}

}
