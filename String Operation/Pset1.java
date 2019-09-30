public class Pset1 {
	public static boolean isAllCharacterUnique(String sIn) {
		// check if current char is same as the next char on a rolling basis
		for (int i = 0; i < sIn.length() - 1; i++) {
			if (sIn.charAt(i) == sIn.charAt(i + 1)) {
				return false;
			}

		}
		return true;
	}

	public static boolean isPermutation(String sIn1, String sIn2) {
		// check length
		if (sIn1.length() != sIn2.length()) {
			return false;
		}

		// iterate through each char of sIn1, check if sIn2 contains the char
		for (int i = 0; i < sIn1.length(); i++) {
			if (sIn2.indexOf(sIn1.charAt(i)) == -1) {
				return false;
			}
		}
		return true;

	}
}
