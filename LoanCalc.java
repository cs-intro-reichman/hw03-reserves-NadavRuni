public class LoanCalc {
	static double epsilon = 0.001;
	static int iterationCounter;

	public static void main(String[] args) {

		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
		iterationCounter = 0; // Reset iteration counter.

		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		
		System.out.println("number of iterations: " + iterationCounter);
	}

	public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double a = loan / n;
		double balance = endBalance(loan, rate, n, a);

		while (balance > 0) {
			a = a + epsilon;
			balance = endBalance(loan, rate, n, a);
			iterationCounter++;
		}
		return a - epsilon;
	}

	public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
		double low = loan / n;
		double high = loan;
		double mid = (high + low) / 2;
		double did = endBalance(loan, rate, n, mid);

		while (Math.abs(did) >= epsilon)
		 {
			if (did > 0) {
				low = mid;

			} else {
				high = mid;
			}
			mid = (low + high) / 2;
			did = endBalance(loan, rate, n, mid);
			iterationCounter++;

		}
		return mid;
	}

	private static double endBalance(double loan, double rate, int n, double payment) {

		int i = 1;
		while (i <= n) {
			loan = (loan - payment);
			loan = loan * ((rate / 100) + 1);
			i++;

		}
		return loan;
	}
}