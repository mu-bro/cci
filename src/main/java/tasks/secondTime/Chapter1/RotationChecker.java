package tasks.secondTime.Chapter1;

public class RotationChecker {

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String s2s2 = s2 + s2;
        return s2s2.contains(s1);
    }
}
