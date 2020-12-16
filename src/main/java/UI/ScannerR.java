package UI;

import java.util.Scanner;

public class ScannerR implements ScannerI{
	Scanner sc = new Scanner(System.in);
	@Override
	public void close() {
		sc.close();
	}

	@Override
	public int nextInt() {
		return sc.nextInt();
	}

}
