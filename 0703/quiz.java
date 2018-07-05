
import java.util.Scanner;
public class quiz {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int no;
		no = stdIn.nextInt();


		for (int i = 1; i <= no; i++) {
			for (int j = 1; j <= no; j++)
				System.out.printf("*", i * j);
			System.out.println();
		}
	}
}
