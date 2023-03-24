package tools;

public class Utility {
	public static String repeatString(int count, String str) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int cnt = 0; cnt < count; cnt++) {
			stringBuilder.append(str);
		}
		return stringBuilder.toString();
	}
}
