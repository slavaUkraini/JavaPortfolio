public class Palindrome {
	/**
	 * @param args
	 * @author Kvitochka
	 */
	
	public boolean isPalindrome(int number) {
		if (number < 0)
			return false;
		int div = 1;
		while (number / div >= 10) {
			div *= 10;
		}
		while (number != 0) {
			int left = number / div;
			int right = number % 10;
			if (left != right)
				return false;
			number = (number % div) / 10;
			div /= 100;
		}
		return true;
	}
	
	public int solution() {
		int solution = 0;
		for (int i = 999; i > 100; i--) {
			for (int j = i; j > 100; j--) {
				int res = i * j;
				if (isPalindrome(res) & (res > solution)) {
					solution = res;
				}
			}
		}
		return solution;
	}
	public static void main(String[] args) {
		System.out.println("Solution = " + new Palindrome().solution());
	}
}
