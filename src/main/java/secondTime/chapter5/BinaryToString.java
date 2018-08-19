package secondTime.chapter5;

public class BinaryToString {

    public static String convert(double number) {
        if (number < 0 || number > 1) return "ERROR";
        StringBuilder result = new StringBuilder("0,");
        for (int i = 0; i < 32; i++) {
            number = number * 2;
            if (number >= 1) {
                number -= 1;
                result.append(1);
            }else {
                result.append(0);
            }
            if (number == 0) {
                break;
            }
        }
        if (number != 0) {
            return "ERROR";
        }
        return result.toString();
    }
}
