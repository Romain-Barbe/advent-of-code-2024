import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Day1 {
	private final ArrayList<String> inputFileContent;

	public Day1(ArrayList<String> inputFileContent) {
		this.inputFileContent = inputFileContent;
	}

	public static void main(String[] args) throws IOException {
		int dayNumber = 1;
		System.out.println("DAY " + dayNumber + " TEST " + dayNumber + " :");
		Day1 test1 = new Day1(Utils.readInputFile("inputs/day" + dayNumber + "/day" + dayNumber + "Test1.txt"));
		test1.solve();
		System.out.println("--------------------------------------------------");
		System.out.println("DAY " + dayNumber + " REAL DATA :");
		Day1 realData = new Day1(Utils.readInputFile("inputs/day" + dayNumber + "/day" + dayNumber + ".txt"));
		realData.solve();
		System.out.println("--------------------------------------------------");
	}

	private void solve() {
		var firstList = new ArrayList<Integer>();
		var secondList = new ArrayList<Integer>();
		var finalDistance = 0;
		var finalSimilarityScore = 0;
		for (String line : inputFileContent) {
			var lineSplitted = line.split(" {3}"); // 3 spaces between each number on each line
			firstList.add(Integer.parseInt(lineSplitted[0]));
			secondList.add(Integer.parseInt(lineSplitted[1]));
		}
		Collections.sort(firstList);
		Collections.sort(secondList);
		for (int i = 0; i < firstList.size(); i++) {
			finalDistance += Math.abs(secondList.get(i) - firstList.get(i));
		}
		for (Integer firstListNumber : firstList) {
			var numberOfTimesNumberFoundInSecondList = 0;
			for (Integer secondListNumber : secondList) {
				if (Objects.equals(firstListNumber, secondListNumber)) {
					numberOfTimesNumberFoundInSecondList++;
				}
			}
			finalSimilarityScore += (firstListNumber * numberOfTimesNumberFoundInSecondList);
		}
		System.out.println("Part 1 result : " + finalDistance);
		System.out.println("Part 2 result : " + finalSimilarityScore);
	}
}
