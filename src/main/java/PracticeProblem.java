import java.util.*;
public class PracticeProblem {

	public static void main(String args[]) {
		int[] sus = recaman(6);
		for (int i = 0; i < sus.length; i++) {
			System.out.println(sus[i]);
		}
	}

	public static int[] recaman(int n) {
		if (n <= 0) {
			return new int[]{};
		}
		int[] theSequence = new int[n];
		HashSet<Integer> alradded = new HashSet<Integer>();
		recamanReal(n, theSequence, alradded);
		return theSequence;
	}

	public static int recamanReal (int n, int[] theSequence, HashSet<Integer> alradded) {
		if (n == 0) {
			return 0;
		}
		if (theSequence[n - 1] == 0) {
			int an = recamanReal(n - 1, theSequence, alradded) - n;
			if (alradded.contains(an)) {
				alradded.add(an + (2*n));
				theSequence[n - 1] = an + (2*n);
				return an + (2*n);
			} else if (an > 0) {
				alradded.add(an);
				theSequence[n - 1] = an;
				return an;
			} else {
				alradded.add(an + (2*n));
				theSequence[n - 1] = an + (2*n);
				return an + (2*n);
			}
		} else {
			return recamanReal(n-1, theSequence, alradded) + n;
		}
	}
}
