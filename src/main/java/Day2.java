import java.io.IOException;
import java.util.ArrayList;

public class Day2 {
	private final ArrayList<String> inputFileContent;

	public Day2(ArrayList<String> inputFileContent) {
		this.inputFileContent = inputFileContent;
	}

	public static void main(String[] args) throws IOException {
		int dayNumber = 2;
		System.out.println("DAY " + dayNumber + " TEST 1 :");
		Day2 test1 = new Day2(Utils.readInputFile("inputs/day" + dayNumber + "/day" + dayNumber + "Test1.txt"));
		test1.solve();
		System.out.println("--------------------------------------------------");
		System.out.println("DAY " + dayNumber + " REAL DATA :");
		Day2 realData = new Day2(Utils.readInputFile("inputs/day" + dayNumber + "/day" + dayNumber + ".txt"));
		realData.solve();
		System.out.println("--------------------------------------------------");
	}

	private void solve() {
		int numberOfLinesSafe = 0;
		for (String line : inputFileContent) {
			boolean isLineSafe = true;
			String[] lineSplitted = line.split(" ");
			int firstValue = Integer.parseInt(lineSplitted[0]);
			int secondValue = Integer.parseInt(lineSplitted[1]);
			int difference = secondValue - firstValue;
			boolean numbersMustIncrease;
			if (difference > 0 && difference <= 3) {
				numbersMustIncrease = true;
			} else if (difference < 0 && difference >= -3) {
				numbersMustIncrease = false;
			} else {
				continue;
			}
			int previousValue = secondValue;
			for (int i = 2; i < lineSplitted.length; i++) {
				int actualValue = Integer.parseInt(lineSplitted[i]);
				difference = actualValue - previousValue;
				if (difference > 0 && difference <= 3 && numbersMustIncrease) {
					previousValue = actualValue;
				} else if (difference < 0 && difference >= -3 && !numbersMustIncrease) {
					previousValue = actualValue;
				} else {
					isLineSafe = false;
					break;
				}
			}

			if (isLineSafe) {
				numberOfLinesSafe++;
			}
		}
		System.out.println("Part 1 result : " + numberOfLinesSafe);
	}
}
