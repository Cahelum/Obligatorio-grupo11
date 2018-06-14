package source;

import java.util.Scanner;

public abstract class UIUtilities {

	public static String pedirString(String letra) {
		Scanner sc = new Scanner(System.in);
		String pedido;
		do {
			System.out.println(letra);
			pedido = sc.nextLine();
		} while (pedido.isEmpty());

		return pedido;
	}

	

	public static boolean siONo(String text) {
		boolean yesOrNo = false;
		boolean ansVer2 = false;
		while (ansVer2 == false) {
			String answer = pedirString(text);
			switch (answer) {
			case "si":
				yesOrNo = true;
				ansVer2 = true;
				break;
			case "no":
				yesOrNo = false;
				ansVer2 = true;
				break;

			}
		}
		return yesOrNo;
	}
}
