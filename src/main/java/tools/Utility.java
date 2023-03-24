package tools;

public class Utility {
	public static String repeatString(int count, String str) {
		StringBuilder result = new StringBuilder();
		for (int cnt = 0; cnt < count; cnt++) {
			result.append(str);
		}
		return result.toString();
	}
}
