package practice;

public class Lahari {

	public static void main(String[] args) {

		int n = 7;
		int m = ((n * 4)) / 2;
		int k = n * 4;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				if (j == 0 && i > 2 || i == 2)
					System.out.print("♥");
				else {
					System.out.print(" ");
				}
			}
			for (int j = 0; j <= i; j++) {
				if (j == i && i > 2 || i == 2)
					System.out.print("♥");
				else {
					System.out.print(" ");
				}
			}
			for (int j = 0; j < m - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < m - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				if (j == 0 && i > 2 || i == 2)
					System.out.print("♥");
				else {
					System.out.print(" ");
				}

			}
			for (int j = 0; j <= i; j++) {
				if (j == i && i > 2 || i == 2)
					System.out.print("♥");
				else {
					System.out.print(" ");
				}

			}
			System.out.println();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 1)
					System.out.print("♥");
				else
					System.out.print(" ");
			}
			for (int j = 0; j < n; j++) {
				if (i == n - 1 || j == 0)
					System.out.print("x");
				else
					System.out.print(" ");
			}
			System.out.print(" ");

			for (int j = 0; j < n; j++) {
				if ((i == 0 && j != n - 1 && j != 0) || i == n / 2 || (j == 0 && i != 0) || (j == n - 1 && i != 0))
					System.out.print("x");
				else
					System.out.print(" ");
			}
			System.out.print(" ");

			for (int j = 0; j < n; j++) {
				if (j == 0 || j == n - 1 || i == n / 2)
					System.out.print("x");
				else
					System.out.print(" ");
			}
			System.out.print(" ");

			for (int j = 0; j < n; j++) {
				if ((i == 0 && j != n - 1 && j != 0) || i == n / 2 || (j == 0 && i != 0) || (j == n - 1 && i != 0))
					System.out.print("x");
				else
					System.out.print(" ");
			}
			System.out.print(" ");

			for (int j = 0; j < n; j++) {
				if ((i == 0 && j != n - 1 && j != 0) || (i == n / 2 && j != n - 1) || (j == 0 && i != 0)
						|| (j == n - 1 && i != 0 && i < n / 2) || (i - j == n / 2 - 1))
					System.out.print("x");
				else
					System.out.print(" ");
			}

			for (int j = 0; j < n; j++) {
				if (i == 0 || i == n - 1 || j == n / 2)
					System.out.print("x");
				else
					System.out.print(" ");
			}
			System.out.print("");

			for (int j = 0; j < n; j++) {
				if (j == n - 2)
					System.out.println("♥");
				else
					System.out.print(" ");
			}

			System.out.println();
		}

		for (int i = 0; i < k; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < k - i; j++) {
				if (j == 0)
					System.out.print("♥");
				else
					System.out.print(" ");

			}
			for (int j = 0; j < k - i; j++) {
				if (j == k - i - 1)
					System.out.print("♥");
				else
					System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}

	}

}
