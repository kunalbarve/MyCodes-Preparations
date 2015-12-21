package InterviewExams;

public class GoogleFindClosestColor {

	static String[] ClosestColor(String[] hexcodes) {
		String[] colors = new String[hexcodes.length];
		for (int i = 0; i < hexcodes.length; i++) {
			colors[i] = calculateDistance(hexcodes[i]);
		}

		return colors;

	}

	public static String calculateDistance(String abc) {
		if (abc.length() == 24) {
			String red = abc.substring(0, 8);
			String green = abc.substring(8, 16);
			String blue = abc.substring(16, 24);

			int redValue = Integer.parseInt(red, 2);
			int greenValue = Integer.parseInt(green, 2);
			int blueValue = Integer.parseInt(blue, 2);

			return calculateEucledian(redValue, greenValue, blueValue);

		}
		return "Ambiguous";
	}

	public static String calculateEucledian(int r, int g, int b) {
		float eucledianBlack = (r - 0) * (r - 0) + (g - 0) * (g - 0) + (b - 0) * (b - 0);
		float eucledianWhite = (r - 255) * (r - 255) + (g - 255) * (g - 255) + (b - 255) * (b - 255);
		float eucledianRed = (r - 255) * (r - 255) + (g - 0) * (g - 0) + (b - 0) * (b - 0);
		float eucledianGreen = (r - 0) * (r - 0) + (g - 255) * (g - 255) + (b - 0) * (b - 0);
		float eucledianBlue = (r - 0) * (r - 0) + (g - 0) * (g - 0) + (b - 255) * (b - 255);
		float smallest = eucledianBlack;
		String name = "Black";

		if (smallest > eucledianWhite) {
			smallest = eucledianWhite;
			name = "White";
		} else if (smallest == eucledianWhite) {
			return "Ambiguous";
		}

		if (smallest > eucledianRed) {
			smallest = eucledianRed;
			name = "Red";
		} else if (smallest == eucledianRed) {
			return "Ambiguous";
		}

		if (smallest > eucledianGreen) {
			smallest = eucledianGreen;
			name = "Green";
		} else if (smallest == eucledianGreen) {
			return "Ambiguous";
		}

		if (smallest > eucledianBlue) {
			smallest = eucledianBlue;
			name = "Blue";
		} else if (smallest == eucledianBlue) {
			return "Ambiguous";
		}

		return name;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
